<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-11-05
  Time: 오전 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
        String operatorName = (String) request.getAttribute("operatorName");
        double firstNumber = (double) request.getAttribute("firstNumber");
        double secondNumber = (double) request.getAttribute("secondNumber");
        double totalValue = (double) request.getAttribute("totalValue");
        %>

        <table border="1">
            <th>계산 종류</th>
            <th>첫번째 숫자</th>
            <th>두번째 숫자</th>
            <th>총계</th>
            <tr>
                <td><%=operatorName%></td>
                <td><%=firstNumber%></td>
                <td><%=secondNumber%></td>
                <td><%=totalValue%></td>
            </tr>
        </table>

</body>
</html>
