# 서버흐름도
![Image](https://github.com/user-attachments/assets/c6a3fe81-c741-4860-8efd-6d32860c7920)

## 기본기능
- 상품전체조회
- 상품단일조회
- 상품등록
- 상품수정
- 상품검색
- 상품삭제


# 이메일 인증 경로
![이메일 인증](https://github.com/user-attachments/assets/d6da28d8-abbd-4e43-84cb-b3131ca3a8cf)

## 이메일 인증 프로세스
![이메일 인증 코드](https://github.com/user-attachments/assets/8ba453a5-833a-4dd5-bb5b-a5b05f13b508)
- 사용자가 이메일 입력 후 인증 버튼 클릭 -> /send-OTPCode-email 로 요청
  
![이메일 인증 서비스](https://github.com/user-attachments/assets/25be6abd-0da9-404f-8665-c96a235523c6)
- MailService의 sendVerificationEmail 메소드를 통해 인증코드 생성 및 이메일 전송
  
![OTP코드 저장](https://github.com/user-attachments/assets/d6612415-cced-40c1-ba23-fb14eff84370)
- OTP 코드 저장 -> 클라이언트 유저에게 전송알림 응답



## 인증코드 검증 프로세스
![회원가입 검증 처리](https://github.com/user-attachments/assets/e5582cba-117f-4aed-b1f0-018da079a085)
- 사용자가 인증 코드 입력 후 확인 버튼 클릭
  
![인증요청 검증](https://github.com/user-attachments/assets/e9d47dfe-a3f5-4588-a5ba-584907ae8272)
- controller에서 verifyEmailCode 메소드 요청
  
![인증코드 검증1](https://github.com/user-attachments/assets/f750cedc-b2cf-48f3-a1d0-0badf622ff9f)
- 이메일 인증 코드 검증 -> 인증 성공시 controller에서 이메일 인증 성공! 알림 / 실패시 인증 코드가 올바르지 않습니다. 를 반환



## 회원가입 완료 프로세스
![회원가입controller](https://github.com/user-attachments/assets/9feb8d6d-a05a-4049-aebc-c6709756c140)
- 사용자가 정보 입력 후 회원가입 버튼 클릭
![멤버 서비스 ](https://github.com/user-attachments/assets/de94f3b0-4295-47b2-bd51-8f7a55a0799d)
- registerMember 메소드 호출
![회원정보 저장](https://github.com/user-attachments/assets/bfa0fa4e-7889-4374-8c19-6da59e26e689)
- 회원 정보 저장
![DB 저장](https://github.com/user-attachments/assets/cbcd3e08-cbbc-4ec9-bbdb-0bdec62227f9)
- 데이터 베이스 저장







   
