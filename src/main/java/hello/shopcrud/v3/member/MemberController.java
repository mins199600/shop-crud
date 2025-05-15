package hello.shopcrud.v3.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("proController")
@Slf4j
public class MemberController {

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

    //회원가입

}
