package hello.shopcrud.v3.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    void saveMember(MemberDto memberDto);   // 회원 정보 저장

    MemberDto loginMember(@Param("memberId") String memberId, @Param("memberPwd") String memberPwd); // 로그인 쿼리
}
