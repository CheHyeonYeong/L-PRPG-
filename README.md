## **About Project ──**

---

**Front-End Developer**

개발기간  `**2024.03.20 ~2024.03.27 (1주)**`


## 📜 서비스 내용

---

- 눈을 떠보니 프로그램속 배열의 시작부분..! 탈출하기 위해선 스택의 끝을 넘어 stackoverflow를 발생시켜야한다.(or outOfBounds)

## 🛠 기술 스택

---

JAVA, Git, GitHub, Notion, IntelliJ

## 🖥 개발 내용

---

# RPG 게임 개발

## 1. 개요

- 플레이어와 몬스터 간의 전투를 중심으로 하는 RPG 게임 개발
- 객체지향 프로그래밍 원리를 활용하여 유지보수가 용이한 코드 구조 설계

## 2. 클래스 설계

### 2.1. Main 클래스

- 게임의 전체 흐름을 제어하는 메인 클래스
- 게임 시작, 플레이어 객체 생성, 이벤트 객체 생성 등의 역할 수행

### 2.2. Charactor 클래스

- 플레이어와 몬스터의 공통 속성과 행동을 정의하는 상위 클래스
    - 속성: `name`, `hp`, `ad` (공격력)
    - 메서드: `atk()` (공격하기), `hit()` (공격 받기)

### 2.3. 하위 클래스

- `Player` 클래스: 플레이어 객체를 생성하고 관리 (Player 클래스를 상속)
- `Monster` 클래스: 몬스터 객체를 생성하고 관리 (Player 클래스를 상속)

### 2.4. 이벤트 클래스

- `Event` 클래스: 게임 내 발생하는 이벤트를 관리
    - 전투 이벤트, 회복 이벤트, 보상 박스 이벤트 등
    - Player ,Monster 객체 생성

### 2.5. 배틀 클래스

- `Battle` 클래스: 전투 관련 로직을 처리
    - 플레이어와 몬스터 간의 공격, 데미지 계산 및  결과 반환 등

# 서비스 화면

---
![서비스 화면](https://github.com/CheHyeonYeong/LooPRPG/assets/62824602/9c9684a7-4761-46b5-8632-91847e44dcd9)


# 자료

---


![LoopRPG_SequenceDiagram](https://github.com/CheHyeonYeong/LooPRPG/assets/62824602/a9deb9b0-48e2-44dd-9a79-d244a309398f)

시퀀스 다이어그램 - 채현영 제작





![LoopRpg ClassDiagram](https://github.com/CheHyeonYeong/LooPRPG/assets/162404075/66dbbe79-23e7-4f3b-a36e-19a0fd64e1a6)


클래스 다이어그램 - 김태훈 제작

