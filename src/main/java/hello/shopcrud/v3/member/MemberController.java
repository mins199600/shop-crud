package hello.shopcrud.v3.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MailService mailService;
    private final OTPCode otpCode;
    private final MemberService memberService;

    @GetMapping("/pro/main")
    public String mainPage() {
        log.info("메인페이지 이동~~");
        return "pro/mainPage";
    }

    @GetMapping("/pro/signUp")
    public String signUpPage() {
        log.info("회원가입 페이지 이동");
        return "pro/signUp";
    }

    // 회원가입 이메일 인증코드 전송
    @PostMapping("/send-OTPCode-email")
    public ResponseEntity<String> sendVerificationEmail(@RequestParam String email) {
        String verificationCode = mailService.sendVerificationEmail(email);
        otpCode.saveOTPCode(email, verificationCode);
        log.info("인증코드 전송 완료");
        return ResponseEntity.ok("인증 코드가 이메일로 전송되었습니다.");
    }

    // 회원가입 인증 코드 검증
    @PostMapping("/verify-email-code")
    public ResponseEntity<String> verifyEmailCode(@RequestParam String email, @RequestParam String code) {
        boolean isValid = otpCode.OTPCode(email, code);
        if (isValid) {
            otpCode.removeOTPCodes(email);
            return ResponseEntity.ok("이메일 인증 성공!");
        } else {
            return ResponseEntity.badRequest().body("인증 코드가 올바르지 않습니다.");
        }
    }

    // 회원가입 처리
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> registerMember(@RequestBody MemberDto memberDto) {
        try {
            // 회원 정보 저장
            memberService.registerMember(memberDto);
            log.info("회원가입 성공: {}", memberDto.getMemberId());
            return ResponseEntity.ok("회원가입 성공!");
        } catch (Exception e) {
            log.error("회원가입 실패", e);
            return ResponseEntity.badRequest().body("회원가입 실패: " + e.getMessage());
        }
    }
}
