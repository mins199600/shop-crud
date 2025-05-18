package hello.shopcrud.v3.member;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // 메인 메서드 - 즉시 인증 코드를 반환하고 이메일은 비동기로 발송
    public String sendVerificationEmail(String toEmail) {
        // 랜덤 인증 코드 생성
        String verificationCode = generateVerificationCode();

        // 비동기로 이메일 발송 (결과를 기다리지 않음)
        sendEmailAsync(toEmail, verificationCode);

        // 인증 코드를 즉시 반환
        return verificationCode;
    }

    // 비동기 이메일 발송 메서드
    @Async
    public CompletableFuture<Void> sendEmailAsync(String toEmail, String verificationCode) {
        // 이메일 내용 작성 - HTML 형식으로 변경하여 인증 코드를 크고 굵게 표시
        String subject = "회원가입 이메일 인증 코드";
        String content =
                "<div style='font-family: Arial, sans-serif; padding: 20px; max-width: 600px;'>" +
                        "<h2 style='color: #333;'>회원가입 인증 코드</h2>" +
                        "<p>안녕하세요! 회원가입을 위해 아래 인증 코드를 입력해주세요.</p>" +
                        "<div style='background-color: #f5f5f5; padding: 15px; border-radius: 5px; margin: 20px 0;'>" +
                        "<p style='margin: 0;'>인증 코드:</p>" +
                        "<h1 style='font-size: 18px; font-weight: bold; color: #007bff; margin: 10px 0;'>" + verificationCode + "</h1>" +
                        "</div>" +
                        "<p>인증 코드는 10분간 유효합니다.</p>" +
                        "<p>감사합니다.</p>" +
                        "</div>";

        try {
            // 이메일 전송 - HTML 형식으로 설정
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(content, true); // true 파라미터로 HTML 형식 활성화

            mailSender.send(message);
            return CompletableFuture.completedFuture(null);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("이메일 전송 실패");
        }
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 6자리 랜덤 숫자
        return String.valueOf(code);
    }
}
