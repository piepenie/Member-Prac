## Member CRUD 실습
- SpringBoot 실습 과제 목적으로 만든 회원 CRUD 입니다.

## 📂 프로젝트 구조

```text
├─main
│  ├─java
│  │  └─org
│  │      └─example
│  │          └─member
│  │              │  MemberApplication.java
│  │              │
│  │              ├─controller
│  │              │      MemberController.java
│  │              │
│  │              ├─dto
│  │              │      CreateMemberRequest.java
│  │              │      CreateMemberResponse.java
│  │              │      GetMemberResponse.java
│  │              │      UpdateMemberRequest.java
│  │              │      UpdateMemberResponse.java
│  │              │
│  │              ├─entity
│  │              │      Member.java
│  │              │
│  │              ├─repository
│  │              │      MemberRepository.java
│  │              │
│  │              └─service
│  │                      MemberService.java
│  │
│  └─resources
│      │  application.properties
│      │
│      ├─static
│      └─templates
└─test
    └─java
        └─org
            └─example
                └─member
                        MemberApplicationTests.java
```

## API 명세
* 저장 : Post /members
* 전체조회 : Get /members
* 단건조회 : Get /members/{memberId} <= memberId = 정수
* 수정 : Put /members/{memberId} 
* 삭제 : Delete /members/{memberId}  
