package hello.shopcrud.v3.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private int id;                     //회원 번호
    private String memberId;            //회원 아이디
    private String memberPwd;           //회원 비밀번호
    private String memberName;          //회원 이름
    private String memberGender;        //회원 성별
    private String memberBirthday;      //회원 생년월일
    private String memberCreateDate;    //회원 생성일자
    private String memberModifiedDate;  //회원 수정일자
    private String memberDeleteDate;    //회원 삭제일자
    private String memberEmail;         //회원 이메일
    private String memberDeleteYn = "N";    //회원 삭제 여부

    public MemberDto() {
    }

    public MemberDto(int id, String memberId, String memberPwd, String memberName, String memberGender, String memberBirthday, String memberCreateDate, String memberModifiedDate, String memberDeleteDate, String memberEmail) {
        this.id = id;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberBirthday = memberBirthday;
        this.memberCreateDate = memberCreateDate;
        this.memberModifiedDate = memberModifiedDate;
        this.memberDeleteDate = memberDeleteDate;
        this.memberEmail = memberEmail;
    }
}
