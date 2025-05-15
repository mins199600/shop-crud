package hello.shopcrud.v3.member;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OTPCode {
    private final Map<String, String> OTPCodes = new HashMap<>();

    // 인증 코드 저장
    public void saveOTPCode(String email, String code) {
        OTPCodes.put(email, code);
    }

    // 인증 코드 검증
    public boolean OTPCode(String email, String code) {
        String savedCode = OTPCodes.get(email);
        return savedCode != null && savedCode.equals(code);
    }

    // 인증 코드 성공 시 삭제
    public void removeOTPCodes(String email) {
        OTPCodes.remove(email);
    }
}
