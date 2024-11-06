<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-11-05
  Time: 오전 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
    <script>
        function validateForm() {
            // 입력값을 가져옵니다.
            let firstNumber = document.getElementById("firstNumber").value; // value 속성 접근
            let secondNumber = document.getElementById("secondNumber").value; // value 속성 접근

            // 입력값이 비어있는지 확인합니다.
            if (firstNumber === "" || secondNumber === "") {
                alert("두 숫자를 모두 입력해주세요.");
                return false; // 폼 제출 방지
            }
            return true; // 폼 제출 허용
        }
    </script>
</head>
<body>
<form action="/calculator/operation" method="post" onsubmit="return validateForm();">
    <select name="operatorName" id="operator">
        <option value="더하기">더하기</option>
        <option value="빼기">빼기</option>
        <option value="곱하기">곱하기</option>
        <option value="나누기">나누기</option>
        <option value="모드연산">모드연산</option>
    </select>
    <input type="number" name="firstNumber" id="firstNumber">
    <input type="number" name="secondNumber" id="secondNumber">
    <button type="submit">제출</button>
</form>
</body>
</html>
