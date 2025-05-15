package hello.shopcrud.v3.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    //회원정보 저장
    public void registerMember(MemberDto memberDto) {
        memberMapper.saveMember(memberDto);
    }
}
