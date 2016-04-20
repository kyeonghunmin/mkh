-- 프로젝트
DROP TABLE IF EXISTS PROJECTS RESTRICT;

-- 맴버
DROP TABLE IF EXISTS MEMBERS RESTRICT;

-- 게시판
DROP TABLE IF EXISTS BOARDS RESTRICT;

-- 능력치
DROP TABLE IF EXISTS STAT RESTRICT;

-- 프로젝트팀
DROP TABLE IF EXISTS TEAM RESTRICT;

-- 매니저
DROP TABLE IF EXISTS MANAGER RESTRICT;

-- 강사
DROP TABLE IF EXISTS TEACHER RESTRICT;

-- 교육과정
DROP TABLE IF EXISTS EDU RESTRICT;

-- 인적정보
DROP TABLE IF EXISTS IDENTITY RESTRICT;

-- 배치
DROP TABLE IF EXISTS APPLY RESTRICT;

-- 프로젝트
CREATE TABLE PROJECTS (
  PNO   VARCHAR(255) NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  PTNO  VARCHAR(255) NOT NULL COMMENT '프로젝트팀번호', -- 프로젝트팀번호
  TITL  VARCHAR(100) NOT NULL COMMENT '프로젝트명', -- 프로젝트명
  ST_DT DATE         NULL     COMMENT '시작일', -- 시작일
  EN_DT DATE         NULL     COMMENT '종료일', -- 종료일
  DESCT VARCHAR(255) NULL     COMMENT '설명', -- 설명
  STATE INTEGER(101) NULL     COMMENT '상태' -- 상태
)
COMMENT '프로젝트';

-- 프로젝트
ALTER TABLE PROJECTS
  ADD CONSTRAINT PK_PROJECTS PRIMARY KEY ( PNO );

-- 맴버
CREATE TABLE MEMBERS (
  MNO  VARCHAR(255) NOT NULL COMMENT '멤버번호', -- 멤버번호
  PTNO VARCHAR(255) NOT NULL COMMENT '프로젝트팀번호', -- 프로젝트팀번호
  INO  VARCHAR(255) NOT NULL COMMENT '인적정보번호' -- 인적정보번호
)
COMMENT '맴버';

-- 맴버
ALTER TABLE MEMBERS
  ADD CONSTRAINT PK_MEMBERS -- 맴버 기본키
    PRIMARY KEY (
      MNO -- 멤버번호
    );

-- 게시판
CREATE TABLE BOARDS (
  BNO   VARCHAR(255) NOT NULL COMMENT '게시물번호', -- 게시물번호
  MNO   VARCHAR(255) NOT NULL COMMENT '멤버번호', -- 멤버번호
  TITL  VARCHAR(100) NOT NULL COMMENT '제목', -- 제목
  CONT  VARCHAR(255) NULL     COMMENT '내용', -- 내용
  VIEWS INTEGER      NULL     COMMENT '조회수', -- 조회수
  PASS  VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
  CR_DT DATE         NOT NULL COMMENT '작성일', -- 작성일
  AUTH  VARCHAR(50)  NOT NULL COMMENT '작성자' -- 작성자
)
COMMENT '게시판';

-- 게시판
ALTER TABLE BOARDS
  ADD CONSTRAINT PK_BOARDS -- 게시판 기본키
    PRIMARY KEY (
      BNO -- 게시물번호
    );

-- 게시판 인덱스
CREATE INDEX IX_BOARDS
  ON BOARDS( -- 게시판
    CR_DT ASC -- 작성일
  );

-- 능력치
CREATE TABLE STAT (
  SNO  VARCHAR(255) NOT NULL COMMENT '능력치번호', -- 능력치번호
  HANS INTEGER(101) NULL     COMMENT '잘생김', -- 잘생김
  ATT  INTEGER(101) NULL     COMMENT '매력', -- 매력
  POW  INTEGER(101) NULL     COMMENT '무력', -- 무력
  INT  INTEGER(101) NULL     COMMENT '지력', -- 지력
  KIND INTEGER(101) NULL     COMMENT '친절도', -- 친절도
  CHA  INTEGER(101) NULL     COMMENT '카리스마', -- 카리스마
  MON  INTEGER(101) NULL     COMMENT '재력', -- 재력
  TEAC INTEGER(101) NULL     COMMENT '교육역량', -- 교육역량
  KNOW INTEGER(101) NULL     COMMENT '지식', -- 지식
  HUM  INTEGER(101) NULL     COMMENT '인맥' -- 인맥
)
COMMENT '능력치';

-- 능력치
ALTER TABLE STAT
  ADD CONSTRAINT PK_STAT -- 능력치 기본키
    PRIMARY KEY (
      SNO -- 능력치번호
    );

-- 프로젝트팀
CREATE TABLE TEAM (
  PTNO  VARCHAR(255) NOT NULL COMMENT '프로젝트팀번호', -- 프로젝트팀번호
  PNM   VARCHAR(50)  NOT NULL COMMENT '프로젝트팀명', -- 프로젝트팀명
  NUMB  INTEGER      NOT NULL COMMENT '참가인원', -- 참가인원
  SLOG  VARCHAR(255) NULL     COMMENT '팀구호', -- 팀구호
  CAPT  VARCHAR(50)  NULL     COMMENT '팀장', -- 팀장
  CR_DT DATE         NULL     COMMENT '팀 창립일' -- 팀 창립일
)
COMMENT '프로젝트팀';

-- 프로젝트팀
ALTER TABLE TEAM
  ADD CONSTRAINT PK_TEAM -- 프로젝트팀 기본키
    PRIMARY KEY (
      PTNO -- 프로젝트팀번호
    );

-- 프로젝트팀 인덱스
CREATE INDEX IX_TEAM
  ON TEAM( -- 프로젝트팀
    PNM ASC -- 프로젝트팀명
  );

-- 매니저
CREATE TABLE MANAGER (
  MANO VARCHAR(255) NOT NULL COMMENT '매니저번호', -- 매니저번호
  INO  VARCHAR(255) NOT NULL COMMENT '인적정보번호' -- 인적정보번호
)
COMMENT '매니저';

-- 매니저
ALTER TABLE MANAGER
  ADD CONSTRAINT PK_MANAGER -- 매니저 기본키
    PRIMARY KEY (
      MANO -- 매니저번호
    );

-- 강사
CREATE TABLE TEACHER (
  TNO VARCHAR(255) NOT NULL COMMENT '강사번호', -- 강사번호
  INO VARCHAR(255) NOT NULL COMMENT '인적정보번호' -- 인적정보번호
)
COMMENT '강사';

-- 강사
ALTER TABLE TEACHER
  ADD CONSTRAINT PK_TEACHER -- 강사 기본키
    PRIMARY KEY (
      TNO -- 강사번호
    );

-- 교육과정
CREATE TABLE EDU (
  ENO  VARCHAR(255) NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  TITL VARCHAR(100) NOT NULL COMMENT '과정명', -- 과정명
  ROOM VARCHAR(100) NOT NULL COMMENT '강의실' -- 강의실
)
COMMENT '교육과정';

-- 교육과정
ALTER TABLE EDU
  ADD CONSTRAINT PK_EDU -- 교육과정 기본키
    PRIMARY KEY (
      ENO -- 교육과정번호
    );

-- 교육과정 인덱스
CREATE INDEX IX_EDU
  ON EDU( -- 교육과정
    ENO ASC -- 교육과정번호
  );

-- 인적정보
CREATE TABLE IDENTITY (
  INO   VARCHAR(255) NOT NULL COMMENT '인적정보번호', -- 인적정보번호
  SNO   VARCHAR(255) NULL     COMMENT '능력치번호', -- 능력치번호
  INM   VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  AGE   INTEGER      NULL     COMMENT '나이', -- 나이
  GEND  CHAR(1)      NULL     COMMENT '성별', -- 성별
  EMAIL VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  TEL   VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
  STEP  VARCHAR(100) NULL     COMMENT '학력', -- 학력
  PASS  VARCHAR(100) NOT NULL COMMENT '암호' -- 암호
)
COMMENT '인적정보';

-- 인적정보
ALTER TABLE IDENTITY
  ADD CONSTRAINT PK_IDENTITY -- 인적정보 기본키
    PRIMARY KEY (
      INO -- 인적정보번호
    );

-- 인적정보 유니크 인덱스
CREATE UNIQUE INDEX UIX_IDENTITY
  ON IDENTITY ( -- 인적정보
    EMAIL ASC -- 이메일
  );

-- 인적정보 인덱스
CREATE INDEX IX_IDENTITY
  ON IDENTITY( -- 인적정보
    INM ASC -- 이름
  );

-- 배치
CREATE TABLE APPLY (
  ANO   VARCHAR(255) NOT NULL COMMENT '배치번호', -- 배치번호
  ENO   VARCHAR(255) NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  TNO   VARCHAR(255) NOT NULL COMMENT '강사번호', -- 강사번호
  MANO  VARCHAR(255) NOT NULL COMMENT '매니저번호', -- 매니저번호
  MNO   VARCHAR(255) NOT NULL COMMENT '멤버번호', -- 멤버번호
  ST_DT DATE         NULL     COMMENT '시작일', -- 시작일
  EN_DT DATE         NULL     COMMENT '종료일', -- 종료일
  CONT  VARCHAR(255) NULL     COMMENT '내용', -- 내용
  HR    DATE         NULL     COMMENT '시간', -- 시간
  DUR   DATE         NULL     COMMENT '기간' -- 기간
)
COMMENT '배치';

-- 배치
ALTER TABLE APPLY
  ADD CONSTRAINT PK_APPLY -- 배치 기본키
    PRIMARY KEY (
      ANO -- 배치번호
    );

-- 프로젝트
ALTER TABLE PROJECTS
  ADD CONSTRAINT FK_TEAM_TO_PROJECTS -- 프로젝트팀 -> 프로젝트
    FOREIGN KEY (
      PTNO -- 프로젝트팀번호
    )
    REFERENCES TEAM ( -- 프로젝트팀
      PTNO -- 프로젝트팀번호
    );

-- 맴버
ALTER TABLE MEMBERS
  ADD CONSTRAINT FK_TEAM_TO_MEMBERS -- 프로젝트팀 -> 맴버
    FOREIGN KEY (
      PTNO -- 프로젝트팀번호
    )
    REFERENCES TEAM ( -- 프로젝트팀
      PTNO -- 프로젝트팀번호
    );

-- 맴버
ALTER TABLE MEMBERS
  ADD CONSTRAINT FK_IDENTITY_TO_MEMBERS -- 인적정보 -> 맴버
    FOREIGN KEY (
      INO -- 인적정보번호
    )
    REFERENCES IDENTITY ( -- 인적정보
      INO -- 인적정보번호
    );

-- 게시판
ALTER TABLE BOARDS
  ADD CONSTRAINT FK_MEMBERS_TO_BOARDS -- 맴버 -> 게시판
    FOREIGN KEY (
      MNO -- 멤버번호
    )
    REFERENCES MEMBERS ( -- 맴버
      MNO -- 멤버번호
    );

-- 매니저
ALTER TABLE MANAGER
  ADD CONSTRAINT FK_IDENTITY_TO_MANAGER -- 인적정보 -> 매니저
    FOREIGN KEY (
      INO -- 인적정보번호
    )
    REFERENCES IDENTITY ( -- 인적정보
      INO -- 인적정보번호
    );

-- 강사
ALTER TABLE TEACHER
  ADD CONSTRAINT FK_IDENTITY_TO_TEACHER -- 인적정보 -> 강사
    FOREIGN KEY (
      INO -- 인적정보번호
    )
    REFERENCES IDENTITY ( -- 인적정보
      INO -- 인적정보번호
    );

-- 인적정보
ALTER TABLE IDENTITY
  ADD CONSTRAINT FK_STAT_TO_IDENTITY -- 능력치 -> 인적정보
    FOREIGN KEY (
      SNO -- 능력치번호
    )
    REFERENCES STAT ( -- 능력치
      SNO -- 능력치번호
    );

-- 배치
ALTER TABLE APPLY
  ADD CONSTRAINT FK_TEACHER_TO_APPLY -- 강사 -> 배치
    FOREIGN KEY (
      TNO -- 강사번호
    )
    REFERENCES TEACHER ( -- 강사
      TNO -- 강사번호
    );

-- 배치
ALTER TABLE APPLY
  ADD CONSTRAINT FK_EDU_TO_APPLY -- 교육과정 -> 배치
    FOREIGN KEY (
      ENO -- 교육과정번호
    )
    REFERENCES EDU ( -- 교육과정
      ENO -- 교육과정번호
    );

-- 배치
ALTER TABLE APPLY
  ADD CONSTRAINT FK_MANAGER_TO_APPLY -- 매니저 -> 배치
    FOREIGN KEY (
      MANO -- 매니저번호
    )
    REFERENCES MANAGER ( -- 매니저
      MANO -- 매니저번호
    );

-- 배치
ALTER TABLE APPLY
  ADD CONSTRAINT FK_MEMBERS_TO_APPLY -- 맴버 -> 배치
    FOREIGN KEY (
      MNO -- 멤버번호
    )
    REFERENCES MEMBERS ( -- 맴버
      MNO -- 멤버번호
    );