package hello.shopcrud.v3.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO member (member_id, member_pwd, member_name, member_email, member_gender, member_birthday) " +
            "VALUES (#{memberId}, #{memberPwd}, #{memberName}, #{memberEmail}, #{memberGender}, #{memberBirthday})")
    void saveMember(MemberDto memberDto);
}

