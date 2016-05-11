# MAVEN 기본 Web Application 폴더 구조
src/main/java         =>  자바 소스 파일을 두는 폴더
        /resources    =>  설정 파일을 두는 폴더.
                          예) .properties, .xml, .txt 등
        /webapp       =>  웹 자원을 두는 폴더.
                          예) .html, .css, .js, .gif, .jpg 등
   /test/java         =>  단위 테스트(JUnit) 자바 소스 파일을 두는 폴더.
        /resources    =>  단위 테스트에 사용되는 설정 파일을 두는 폴더.

# 이클립스 프로젝트 준비
1) build.gradle 파일 준비
2) "gradle eclipse" 명령 실행
3) 이클립스로 프로젝트 로딩

# ContextLoaderListener 준비
- 서블릿에서 공통으로 사용할 스프링 IoC 컨테이너를 준비한다.
1) "bitcamp.pms/listener" 패키지 생성
2) ContextLoaderListener 클래스 생성
   - ServletContextListener 구현
   - contextInitialized(), contextDestroyed() 오버라이딩
3) web.xml에 리스너 배치 설정하기
   - src/main/webapp/WEB-INF 폴더 추가
   - web.xml 파일 준비 (기존 프로젝트의 파일을 가져온다)
   - web.xml 파일을 현재 프로젝트에 맞게끔 초기화시킨다.
	 - 리스너 등록
     <listener>
       <listener-class>bitcamp.pms.listener.ContextLoaderListener</listener-class>
     </listener>
4) 톰캣 서버에 추가한 후 실행 테스트
5) 스프링 설정 파일 준비
   - src/main/webapp/WEB-INF/conf 폴더 추가
   - 스프링 설정 파일 준비 (project01에서 가져온다)
     WEB-INF/conf/application-context.xml
   - 스프링 설정 파일을 현재 프로젝트에 맞게 변경한다.
6) 스프링 설정 파일의 위치 정보를 컨텍스트 파라미터로 등록한다.
   - web.xml에 등록
     <context-param>
       <param-name>contextConfigLocation</param-name>
       <param-value>/WEB-INF/conf/application-context.xml</param-value>
     </context-param>
7) 리스너에서 스프링 IoC 객체 생성하기
   - ContextLoaderListener.contextInitialized() 메서드 편집
     (web03에 ContextLoaderListener 클래스 참조!)

# 게시판을 위한 mybatis 준비
1) "bitcamp.pms.vo" 패키지 생성
2) Board 값 객체 준비
3) "bitcamp.pms.dao" 패키지 생성
4) 게시판 DAO 준비
   - BoardDao 인터페이스 준비
5) 게시판 맵퍼 파일 생성
   - src/main/resources/bitcamp/pms/dao 폴더 생성
   - BoardDao.xml 파일 준비

# 게시판 서블릿 준비
1) "bitcamp.pms.servlet" 패키지 생성
2) BoardListServlet 클래스 생성
   - BoardDao를 사용하여 게시물을 출력한다.
3) BoardAddServlet 클래스 생성
   - doGet(): 게시물 입력 폼 출력
   - doPost(): 게시물 입력 결과 출력
4) POST 요청 데이터에 대한 한글 처리
   - 스프링에서 제공하는 필터를 사용할 것.
   - web.xml에 스프링 필터 등록하라!



















   
