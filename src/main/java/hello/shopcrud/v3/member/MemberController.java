package hello.shopcrud.v3.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MailService mailService;
    private final OTPCode otpCode;
    private final MemberService memberService;

    // 메인 페이지
    @GetMapping("/pro/main")
    public String mainPage(HttpSession session, Model model) {
        // 세션에서 로그인 멤버 정보 가져오기
        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");

        if (loginMember != null) {
            log.info("로그인된 사용자: {}", loginMember.getMemberId());
            model.addAttribute("loginMember", loginMember);
        } else {
            log.info("로그인된 사용자가 없습니다.");
        }

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

    //로그인 페이지 이동
    @GetMapping("/login")
    public String loginPage() {
        return "pro/login";
    }

    //로그인 기능
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestData, HttpSession session) {
        String memberId = requestData.get("memberId");
        String memberPwd = requestData.get("memberPwd");

        log.info("로그인 시도: memberId={}, memberPwd={}", memberId, memberPwd);

        if (memberId == null || memberPwd == null) {
            return ResponseEntity.badRequest().body("아이디와 비밀번호를 입력해주세요.");
        }

        MemberDto member = memberService.login(memberId, memberPwd);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패: 아이디 또는 비밀번호를 확인해주세요.");
        }

        // 로그인 성공 시 세션에 사용자 정보 저장
        session.setAttribute("loginMember", member);
        log.info("세션에 저장된 로그인 정보: {}", session.getAttribute("loginMember"));

        return ResponseEntity.ok(member);
    }

    // 로그아웃 기능 추가
    @PostMapping("/logout")
    @ResponseBody
    public ResponseEntity<String> logout(HttpSession session) {
        try {
            // 세션 무효화
            session.invalidate();
            log.info("로그아웃 성공");
            return ResponseEntity.ok("로그아웃 성공!");
        } catch (Exception e) {
            log.error("로그아웃 실패", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("로그아웃 실패: " + e.getMessage());
        }
    }
}



