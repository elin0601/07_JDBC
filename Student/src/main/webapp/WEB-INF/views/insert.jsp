<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학생 정보 추가</title>
</head>
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
            학점 : <input type="number" name="point">
        </div>

        <div>
            입학일 : <input type="date" name="entranceDate">
        </div>

        <%-- <div>
            휴학 여부 : <button type="button"
                                class = "absenceYn"
                                data-student-no="${student.studentNo}">
                                ${student.absenceYn}</button>
        </div>

        <div>
            휴학 날짜 : <input type="date" name="absenceDate">
        </div>

        <div>
            졸업 여부 : <button type="button"
                                class = "graduationYn"
                                data-student-no="${student.studentNo}">
                                ${student.graduationYn}</button>
        </div>

        <div>
            졸업 날짜 : <input type="date" name="graduationDate">
        </div>
 --%>
        <button type="submit">추가 하기</button>

    </form>

    <script src="/resources/js/insert.js"></script>

</body>
</html>