<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-11-04
  Time: 오후 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSP 기본 문법</h1>
    <!--HTML 주석입니다-->
    <%--JSP 주석입니다--%>

    <!--선언태그 : 선언과 동시에 초기화도 가능은 하다-->
    <%!
        private String name;
        private int age;
    %>

    <!--스크립트릿 태그 : 선언한 변수를 사용함-->
    <%
          name = "조평훈";
          age = 20;

        System.out.println("name = " + name);
        System.out.println("age = " + age);
    %>
    <!--표현 태그 : ;은 찍지 않았다.-->
    <!--템플릿엔진 : 웹어플리케이션에서 동적인 HTML 을 생성하기 위해 사용되는 도구 -->
    <h3>이름 : <%= name %></h3>
    <h3>나이 : <%= age %></h3>
</body>
</html>
<%--마우스 우클릭 페이지소스보기에서 JSP주석은 안보여요--%>
<%--이것은 html 파일이지만 실제론 자바파일이에요--%>