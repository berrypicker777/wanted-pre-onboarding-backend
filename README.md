## 원티드 프리온보딩 백엔드 인턴십 선발과제

### ⚒️ 기술 스택
- Java 11
- SpringBoot 2.7.16
- Spring Data Jpa
- MySQL

### 📝 테이블 설계

![image](https://github.com/berrypicker777/wanted-pre-onboarding-backend/assets/90882909/13d1feb1-87cc-4e60-902e-9e023ca77025)

### 🎲 구현 내용
- open-in-view를 false로 두고 controller와 service의 역할을 명확히 분리함.
  
- ExceptionHandler, Custom Exception 구현
  - HTTP 상태 코드 400번, 404번, 500번 에러에 대해 에러 메시지를 응답하도록 함.
    
- 응답 메시지 형태를 통일하기 위해서 ResponseDTO 작성
  - 에러 메시지 또한 ResponseDTO에 담아서 보내도록 구현함.
    
- 채용 공고 등록하기
  
- 채용 공고 수정하기
  - JPA의 dirty checking을 이용하여 구현함.
    
- 채용 공고 삭제하기
  
- 채용 공고 목록 조회하기
  - Query String 여부에 따라 검색 또는 전체 목록이 조회되도록 구현함.
    
- 채용 공고 상세 조회하기
  - 해당 공고를 작성한 회사의 다른 채용 공고들의 id도 조회되도록 구현함.
    
- 채용 공고 지원하기
  - 하나의 사용자가 한 번만 지원할 수 있도록 처리함.
    
- Unit Test 구현
  - Junit5 프레임워크와 Mockito 라이브러리를 조합하여 별도의 Mock 환경에서 테스트가 이루어질 수 있도록 구성함.
  - MockDummyEntity를 이용해 Unit Test에서 사용할 엔티티를 생성하도록 함.
  - given, stub, when, then의 구조로 테스트 코드를 작성함.

### 💡 Code 및 Commit 컨벤션
- [Wiki](https://github.com/berrypicker777/wanted-pre-onboarding-backend/wiki/%EC%BB%A8%EB%B2%A4%EC%85%98)
