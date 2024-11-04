<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-11-04
  Time: 오후 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Include 지시자</h1>
    <div><%@include file="today.jsp"%></div>
</body>
</html>

<%--header.jsp nav.jsp footer.jsp 등 하나만 만들어두면 include가 됩니다.--%>
<%--화면을 만들때 header nav footer 등으로 기본구성이 되는데 페이지마다 header nav footer 계속 만들면 힘드니까
    header.jsp 파일을 만들고 nav.jsp 파일을 만들고 필요한 페이지 마다 include를 하면 재작성할 필요가 없는 것입니다.--%>