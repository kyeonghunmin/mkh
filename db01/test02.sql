/* 주제 : not null, unique, default, primary key
*/

1. 테이블 생성
create table 테이블명(컬럼정보);

create table test01(
  tno int,
  name char(5)
);


2. 값 입력
/* 컬럼을 지정하지 않는 경우,
 * => create table에 선언된 순서대로 모든 컬럼의 값을 지정해야 한다.
 */
insert into test01 values('hong', 1); /* tno 컬럼의 값이 0이 된다. */
insert into test01 values(2, 'hong'); /* 가능 */
insert into test01 values(3); /* 에러 */

/* 특정 컬럼의 값 입력을 생략한 경우,
 * => null 값으로 설정된다.
 */
insert into test01(tno) values(3);
insert into test01(name) values('홍길동');


3. 특정 컬럼을 필수 입력 컬럼으로 만드는 방법
=> MySQL의 경우 not null 컬럼의 값을 생략하면 그 타입의 기본 값이 저장된다.
   int : 0, char : 빈문자
예) tno 컬럼을 필수 입력 컬럼으로 만든다.
drop table test01;
create table test01(
  tno int,
  name char(5) not null /* 컬럼 선언에 not null 옵션을 붙인다. */
);

insert into test01(tno) values(4);
insert into test01(name) values('홍길동');
insert into test01(tno, name) values(1, '홍길동');
insert into test01(tno, name) values(1, '임꺽정');


4. 특정 컬럼의 값이 중복되지 않게 만드는 방법
=> unique 옵션을 붙인다.
=> 값이 중복되면 오류 발생. 값이 없으면 중복 여부를 검사하지 않는다.

drop table test01;
create table test01(
  tno int unique,
  name char(5) not null
);
insert into test01(tno, name) values(1, '홍길동');
insert into test01(tno, name) values(2, '임꺽정');
insert into test01(tno, name) values(1, '이순신'); /* 오류 : tno에 unique가 붙었기 때문에 1이 또 올 수 없다. */
insert into test01(name) values('이순신');


5. 특정 컬럼의 값이 중복되지 않게 만드는 방법2
=> unique 옵션을 붙인다.
=> not null 옵션을 이용하여 필수 속성으로 만든다.

drop table test01;
create table test01(
  tno int unique not null,
  name char(5) not null
);

insert into test01(tno, name) values(1, '홍길동');
insert into test01(tno, name) values(2, '임꺽정');
insert into test01(tno, name) values(1, '이순신'); /* 값 중복 오류 */
insert into test01(name) values('이순신'); /* 가능; tno가 0이된다.*/ 
insert into test01(name) values('이순신'); /* 오류; tno가 0이 있는데 또 0으로 설정할 수 없기 때문 */ 


6. 값을 입력하지 않으면 지정한 값으로 자동으로 넣는 방법
=> default 옵션을 사용한다.

drop table test01;
create table test01(
  tno int unique not null,
  name char(5) default '홍길동'
);

insert into test01(tno, name) values(1, '홍길동');
insert into test01(tno, name) values(2, '임꺽정');
insert into test01(tno) values(3); /* name 값을 주지 않으면 default인 '홍길동'으로 설정된다. */
insert into test01(tno) values(4);


7. unique 컬럼 중에서 데이터를 구분할 때 사용할 컬럼은 값이 없어서는 안된다.
=> unique에 not null을 추가하라.

=> not null 추가 전
drop table test01;
create table test01(
  tno int unique,
  name char(5) default '홍길동',
  email char(10) unique
);

insert into test01(tno, name) values(1, '홍길동');
insert into test01(tno, name) values(2, '임꺽정');
insert into test01(name, email) values('이순신', 'lee@');
insert into test01(name, email) values('강감찬', 'kang@');
insert into test01(tno, name) values(2, '임꺽정');  /* tno 중복. 오류! */
insert into test01(name, email) values('임꺽정', 'leem@'); /* tno는 null; email은 중복 안됨. 가능! */
insert into test01(name, email) values('강감찬', 'kang@'); /* email 중복. 오류! */
insert into test01(tno, name) values(3, '강감찬'); /* email=null, tno=중복안됨. 가능! */
insert into test01(name) values('강감찬');
insert into test01(name) values('강감찬');
insert into test01(name) values('강감찬');

=> 레코드(테이블에 들어있는 값)를 구분하기 위한 조건
   1) 해당 컬럼의 값이 중복되어서는 안된다.
   2) null을 허용해서는 안된다. (null을 허용하면 구분할 수 없기 때문)
   3) 회원 번호를 레코드 구분 컬럼으로 사용한다면 다음과 같이 선언한다.
drop table test01;
create table test01(
  tno int unique not null,
  name char(5) default '홍길동',
  email char(10) unique
);

insert into test01(tno, name) values(1, '홍길동');
insert into test01(tno, name) values(2, '임꺽정');
insert into test01(name, email) values('이순신', 'lee@'); /* tno=0 */
insert into test01(name, email) values('강감찬', 'kang@'); /* tno=0 인데, 0은 이미 존재하기 때문에 오류 발생 */
insert into test01(tno, name, email) values(3, '이순정', 'lee@'); /* 이메일이 중복되어 오류 발생 */

=> 결론:
   1) 값이 중복되어서는 안되는 컬럼은 unique로 선언한다.
   2) 레코드를 구분할 때 사용할 컬럼은 unique + not null 로 선언한다.

   
8. 레코드를 식별하는 컬럼에 대해 unique not null의 단축 문법
=> primary key
=> unique not null 과 같다. 어느 컬림이 식별자로 사용되는지 빠르게 확인할 수 있다.
drop table test01;
create table test01(
  tno int primary key,
  name char(5) default '홍길동',
  email char(10) unique
);
   
insert into test01(tno, name) values(1, '홍길동');
insert into test01(tno, name) values(2, '임꺽정');
insert into test01(name, email) values('이순신', 'lee@');  /* tno=0 */
insert into test01(name, email) values('강감찬', 'kang@'); /* tno 중복 오류 */
insert into test01(tno, name, email) values(3, '이순정', 'lee@');
   
   
   
   
   
   
   
   









