<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학생관리</title>
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
    <h1>전체 학생 조회</h1>

    <table border="1">
        <thead>
            <tr>
                <th>순서</th>
                <th>학번</th>
                <th>이름</th>
                <th>학과</th>
                <th>생년월일</th>
                <th>주소</th>
                <th>이번 학기 학점</th>
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

                   <th>
                   <button type = "button" class = "update-btn">학생 정보 수정<button>
                   </th>
                    
                    <th>
                        <button type = "button" class = "delete-btn">삭제</button>
                    </th>

                </tr> 
         </c:forEach>
        </tbody>
    </table>

<br>
 <button id="goToList">목록으로</button>
    <c:if test="${not empty message}" >
        <script>
            alert("${message}");
        </script>
        <c:remove var="message"/>
    </c:if>

    <c:remove var="message" scope="session" />

    <script src = "/resources/js/selectAll.js"></script>

</body>
</html>