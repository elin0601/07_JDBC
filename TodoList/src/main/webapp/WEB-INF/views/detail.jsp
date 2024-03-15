<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${todo.todoTitle}</title>

    <style>
        table {
            border-collapse : collapse;
        }

        .todo-content {
            /* pre 태그처럼 처리 == HTML에 작성된 모양 그대로 화면에 출력 */
            white-space : pre-wrap;
        }
    </style>

</head>
<body>

    <h3>${todo.todoTitle}</h3>

    <table border="1">
        <tr>
            <th>번호</th>
            <td>${todo.todoNo}</td>
        </tr>

        <tr>
            <th>등록 날짜</th>
            <td>${todo.regDate}</td>
        </tr>

        <tr>
            <th>완료 여부</th>
            <td>
                <button type="button" class = "complete-btn">${todo.complete}</button>
            </td>
        </tr>

        <tr>
            <th>내용</th>
            <td class="todo-content">${todo.todoContent}</td>
        </tr>

    </table>

    <button id="goToList">목록으로</button>
    <button id="udpateBtn">수정</button>
    <button id="deleteBtn">삭제</button>
    
</body>
</html>