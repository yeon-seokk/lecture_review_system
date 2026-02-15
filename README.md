# First Project: 강의 리뷰 시스템
> **스프링 부트와 JPA를 활용하여 만든 간단한 강의 평가 및 리뷰 저장 서비스.**

---

## tech stack
- **language**: Java 17
- **Framework**: Spring Boot 3.5
- **Database**: H2 Database, MySQL(전환 예정)
- **AOP**: Aspect Oriented Programming을 활용한 실행 로그 기록

---

## KeyFeatures
1. **리뷰 등록**: 강의명, 교수명, 별점, 한 줄 평을 입력하여 DB에 저장
2. **리뷰 목록 조회**: 저장된 모든 리뷰를 리스트 형태로 확인
3. **중복 로직 검증**: 동일한 강의/교수명에 대한 중복 등록 방지 로직 구현 (추후 변경 예정)
4. **로깅 시스템(AOP)**: 모든 서비스 메서드 호출 시 START/END 로그를 자동으로 남겨 시스템 흐름 추적

---

## 주요 고민 및 해결 과정
- **순환 참조 에러**: AOP를 `SpringConfig`에 수동 등록하면서 발생한 순환 참조 문제를 해결. (`@Component` 방식으로 전환.)
- **데이터베이스 전환**: 최대한 팀 프로젝트와 실무에서 사용을 하는 DB 방식으로 전환 고려.
- **Git & Github 활용**: 팀 프로젝트에는 github가 필수이므로 개인 프로젝트 코드들을 github에 push하며 활용법을 익힘.

---

## 실행방법
1. h2 database 실행
2. `./gradlew bootRun` 실행
3. `localhost:8080` 접속
