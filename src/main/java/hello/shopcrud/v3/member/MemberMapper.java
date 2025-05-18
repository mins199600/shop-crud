package hello.shopcrud.v3.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void saveMember(MemberDto memberDto);   // 회원 정보 저장
}
