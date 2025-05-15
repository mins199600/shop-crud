package hello.shopcrud.v3.member;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendVerificationEmail(String toEmail) {
        // 랜덤 인증 코드 생성
        String verificationCode = generateVerificationCode();

        // 이메일 내용 작성
        String subject = "회원가입 이메일 인증 코드";
        String content = "안녕하세요! 회원가입을 위해 아래 인증 코드를 입력해주세요.\n\n" +
                "인증 코드: " + verificationCode;

        try {
            // 이메일 전송
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(content);

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("이메일 전송 실패");
        }

        return verificationCode; // 인증 코드를 반환하여 서버에서 저장
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 6자리 랜덤 숫자
        return String.valueOf(code);
    }

}
