function de() {
    var n = document.getElementById("name1");
    var name1 = n.value;
    var reg = new RegExp(/^\w{6,20}$/);
    if (n != null && reg.test(name1)) {
        alert("姓名正確");
    } else {
        alert("重新輸入");
    }
    var n = document.getElementById("pwd");
    var pass = n.value;
    var reg1 = new RegExp(/^[a-zA-Z0-9_-]{6,16}$/);
    if (n != null && reg1.test(pass)) {
        alert("密碼正確");
    } else {
        alert("密碼錯誤");
    }
    var n = document.getElementById("nickname");
    var nickname = n.value;
    var reg2 = new RegExp(/^\w{5,20}$/);
    if (name1 == reg == reg2 && reg1 == pass && reg2 == nickname) {
        alert("登陸成功");
    }
}