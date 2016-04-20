주제 : PK, UK, FK를 지정하는 다양한 방법

1. create table 에서 지정하기
drop table test01;
create table test01(
  tno int primary key,
  name char(5)
);


2. create table의 제약조건 설정 부분에서 지정하기
drop table test01;
create table test01(
  tno int,
  name char(5),
  constraint test01_pk primary key (tno)
);


3. alter table에서 primary key 지정하기
=> 실무에서는 이 방법을 많이 사용한다.
=> constraint test01_pk : 라벨같은 역할
drop table test01;
create table test01(
  tno int,
  name char(5)
);

alter table test01
  add constraint test01_pk primary key (tno);
  
alter table test01
  add constraint test01_uq unique (name);
  
  
4. FK를 지정하는 방법
drop table team;
drop table member;
create table member(
  mno int,
  name varchar(50),
  teamno int
);
create table team(
  tno int,
  name varchar(50)
);

alter table member
  add constraint member_pk primary key (mno);
  
alter table team
  add constraint team_pk primary key (tno);

  
alter table member
  modify name varchar(50) not null;
  
alter table member
  modify teamno int not null;
  
alter table team
  modify name varchar(50) not null;

/* 존재하지 않는 팀 번호를 넣을 수 있다. => 데이터의 결함이 발생한다. */
insert into member values(1,'홍길동',100); 

/* member의 teamno 컬럼에 반드시 team 테이블의 존재하는 PK 값을 넣도록 제약을 가해야 한다. */ 
alter table member
  add constraint member_team_fk foreign key (teamno) references team (tno);

/* member에서 팀 번호를 사용하려면 먼저 팀에 데이터를 추가해야 한다. */
insert into team values(100,'오호라');
insert into team values(200,'우하하');

/* 존재하는 팀 번호를 넣을 때만 회원 정보 입력이 가능하다. */
insert into member values(1,'홍길동',100);

/* 팀 삭제 */
delete from team where tno=200; /* 삭제 가능 */
delete from team where tno=100; /* 삭제 불가 : 100은 참조되고 있기 때문 (무결성 제약조건) */

/* 자식테이블의 데이터를 모두 지운 다음에, 부모 테이블의 데이터를 지울 수 있다. */
delete from member where mno=1; /* 참조하고 있는 자식 테이블의 데이터를 먼저 지운다. */
delete from team where tno=100;
















