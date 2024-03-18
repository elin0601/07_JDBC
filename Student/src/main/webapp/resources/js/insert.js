const absenceYnBtn = document.querySelector(".absenceYn");

absenceYnBtn.addEventListener("click", e => {
    
    const studentNo = e.target.dataset.studentNo;

    let change = e.target.innerText;

    change = (change === 'Y') ? 'N' : 'Y';

    location.href=`/student/change?studentNo=${studentNo}&change=${change}`;

}); 

const graduationYnBtn = document.querySelector(".graduationYn");

graduationYnBtn.addEventListener("click", e => {
    
    const studentNo = e.target.dataset.studentNo;

    let changeOther = e.target.innerText;

    changeOther = (changeOther === 'Y') ? 'N' : 'Y';

    location.href=`/student/changeOther?studentNo=${studentNo}&changeOther=${changeOther}`;

}); 