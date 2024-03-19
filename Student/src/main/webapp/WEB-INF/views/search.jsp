<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> 조회 결과</title>
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
   <h3>검색하기</h3>
    <form action="/student/search" method="GET">
        검색어 입력 : <input type="text" name="studentNo">
        <button>검색</button>
    </form>

    <h2>${param.studentNo} 학번 조회 결과</h2>

    <c:if test="${empty studentList}">
        <h3>해당 학생의 조회 결과가 없습니다.</h3>
    </c:if>

    <c:if test="${not empty studentList}">
        <table border="1">
        <thead>
            <tr>
                <th>순서</th>
                <th>학번</th>
                <th>이름</th>
                <th>학과</th>
                <th>생년월일</th>
                <th>주소</th>
                <th>학점</th>
                <th>입학 날짜</th>
                <th>휴학 여부</th>
                <th>휴학 날짜</th>
                <th>졸업 여부</th>
                <th>졸업 날짜</th>
            </tr>
        </thead>
           
        <tbody>      
             <c:forEach items="${studentList}" var="student" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${student.studentNo}</td>
                    <td>${student.studentName}</td>
                    <td>${student.studentDept}</td>
                    <td>${student.studentSsn}</td>
                    <td>${student.address}</td>
                    <td>${student.point}</td>
                    <td>${student.entranceDate}</td>
                    <td>${student.absenceYn}</td>
                    <td>${student.absenceDate}</td>
                    <td>${student.graduationYn}</td>
                    <td>${student.graduationDate}</td>
                </tr>
             </c:forEach>
        </tbody>
    </table>
    </c:if>
<br>
 <button id="goToList">목록으로</button>

  <script src = "/resources/js/selectAll.js"></script>

    
</body>
</html>