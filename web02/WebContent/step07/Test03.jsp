<%-- .jsp는 바로 실행되지 않는다.
	   자바 클래스 파일로 변환되서 실행되게 된다.
	   변환된 클래스 파일 위치 : 
	   C:\bitcamp\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\web02\org\apache\jsp\step07
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% int i = 0; %>
<head>
<meta charset="UTF-8">
<%
int j = 20;
int sum = 0;
%>
<title>JSP</title>
</head>
<body>
<%
sum = i + j;
%>
<h1>스크립트릿</h1>
<ul>
	<li>자바 코드를 삽입시키는 JSP 태그이다.
	<li>_jspService() 메서드 안에 선언된 순서대로 삽입된다.
	<li>작성한 코드가 그대로 복사된다.
	<li>메서드 안에 작성할 수 있는 자바 문법은 100% 가능!
</ul>
<% out.println("sum = " + sum); %>

<p>
<% 
String[] names = {"홍길동", "임꺽정", "이순신", "권율"};
for (String name : names) {
  out.write(name);%><br>
  <br>
<%} %>  
</p>
</body>
</html>








