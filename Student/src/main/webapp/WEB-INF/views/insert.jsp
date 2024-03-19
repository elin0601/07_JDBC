<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학생 정보 추가</title>
</head>
<style>
    body {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
       }

</style>

<body>
    <h3>학생 정보 추가</h3>
    <form action="insert" method = "POST">

        <div>
            학생 번호 : <input type="text" name="studentNo">
        </div>

        <div>
            학생 이름 : <input type="text" name="studentName">
        </div>
        <div>
            학과 : <input type="text" name="studentDept">
        </div>

        <div>
            생년월일 : <input type="date" name="studentSsn">
        </div>

        <div>
            학생 주소 : <input type="text" name="address">
        </div>

        <div>
            이번 학기 학점 : <input type="number" name="point" min="1.0" max="4.5" step="0.1">
        </div>

        <div>
            입학일 : <input type="date" name="entranceDate">
        </div>

        <br>
        <button type="submit">추가 하기</button>

    </form>
        <c:if test="${not empty message}" >
        <script>
            alert("${message}");
        </script>
        <c:remove var="message"/>
    </c:if>
</body>
</html>