
// 목록으로 버튼 동작
const goToList = document.querySelector("#goToList");

goToList.addEventListener("click", () => {
    location.href="/"; // 메인 페이지 요청
});


const updateBtnList = document.querySelectorAll(".update-btn");
updateBtnList.forEach((btn,index) => {

    btn.addEventListener("click", e => {
        const tr = e.target.closest("tr");
        const studentNo = tr.children[1].innerText;
        location.href = "/student/update?studentNo=" + studentNo;
    });
});

const deleteBtnList = document.querySelectorAll(".delete-btn");

for(let btn of deleteBtnList) {
    btn.addEventListener("click", e=> {
        const studentNo = e.target.closest("tr").children[1].innerText;

        if(confirm(`${studentNo} 님의 정보를 정말 삭제 하시겠습니까?`)) {
        const form = document.createElement("form");
        form.action="/student/delete";
        form.method="POST";

        const input = document.createElement("input");
        input.type="hidden";
        input.value = studentNo;
        input.name = "studentNo";

        form.append(input);

        document.querySelector("body").append(form);

        form.submit();
        } else {
            alert("학생 정보 수정이 취소되었습니다");
        }
    });
};
