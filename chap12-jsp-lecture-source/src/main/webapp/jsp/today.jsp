<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      Date today = new Date();
      SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
      String output = sdf.format(today);
    %>
    <h3 style="color:red"><%=output%></h3>
</body>
</html>

<%--해당하는 페이지를 직접 보여주는 것이 아니라 끌어다가 보여줄 것--%>