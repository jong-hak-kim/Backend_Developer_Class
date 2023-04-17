// 데이터 입력 확인
const onSubmitHandler = () => {
    const id = document.getElementById("id").value;
    const pw1 = document.getElementById("password1").value;
    const pw2 = document.getElementById("password2").value;
    const name = document.getElementById("name").value;

    let idCollect = [id, pw1, pw2, name];
    idCollect.forEach(function (value, index) {
        if (!value.trim()) {
            document.getElementsByClassName("error_next_box")[index].style.display = "block";
            return;
        }
        document.getElementsByClassName("error_next_box")[index].style.display = "none";
    });
}