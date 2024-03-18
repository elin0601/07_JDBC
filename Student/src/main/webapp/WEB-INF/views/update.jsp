<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학생 정보 수정</title>
</head>
<body>

    <h3>${student.studentName}님의 정보 수정</h3>
    <form action="/student/update" method="POST">
        <div>
            학생 학과 : <input type="text" name="studentDept" value = "${student.studentDept}">
        </div>
        <div>
            학생 주소 : <input type="text" name="address" value = "${student.address}">
        </div>
        <div>
            학생 학점 : <input type="number" name="point" value = "${student.point}">
        </div>
        <div>
            휴학 여부 : <input type="text" name="absenceYn" value = "${student.absenceYn}">
        </div>
        <div>
            휴학 날짜 : <input type="text" name="absenceDate" value = "${student.absenceDate}">
        </div>
        <div>
            졸업 여부 : <input type="text" name="graduationYn" value = "${student.graduationYn}">
        </div>
        <div>
            졸업 날짜 : <input type="text" name="graduationDate" value = "${student.graduationDate}">
        </div>


    </form>
    
    

    <c:if test="${not empty message}" >
        <script>
            alert("${message}");
        </script>
        <c:remove var="message"/>
    </c:if>

</body>
</html>