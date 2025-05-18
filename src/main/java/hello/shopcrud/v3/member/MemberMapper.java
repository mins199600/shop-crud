package hello.shopcrud.v3.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    //회원가입 멤버 저장(데이터)
    @Insert("INSERT INTO member (member_id, member_pwd, member_name, member_email, member_gender, member_birthday, member_delete_yn) " +
            "VALUES (#{memberId}, #{memberPwd}, #{memberName}, #{memberEmail}, #{memberGender}, #{memberBirthday},'N')")

    void saveMember(MemberDto memberDto);   //회원가입 유저 완료


}

