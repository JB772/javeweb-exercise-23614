function vali() {
    var pws1 = document.getElementById("id");
    var as = pws1.value;
    var pws2 = new RegExp(/^\w{6,20}$/);
    if (pws1 != null && pws2.test(as)) {
        alert("帳號格式正確");
    } else {
        alert("帳號格式錯誤");
    }
    var pass = document.getElementById("pwd");
    var reg = new RegExp(/^[a-zA-Z0-9_-]{6,16}$/);
    var reg1 = pass.value;
    if (reg.test(reg1)) {
        alert("密碼正確");
    } else {
        alert("密碼錯誤");
        return false;
    }
    var passAB = document.getElementById("pwd1");
    var reg2 = new RegExp(/^[a-zA-Z0-9_-]{6,16}$/);
    var reg3 = passAB.value;
    if (reg1 == reg3) {
        alert("密碼驗證成功");
    } else {
        alert("兩次密碼不一樣");
    }
    var nickname = document.getElementById("nickname");
    var reg = new RegExp(/^[A-Za-z0-9\u4e00-\u9fa5][nickname protected][a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/);
    var em = nickname.value;
    if (reg.test(em)) {
        alert("暱稱長度正確");
    } else {
        alert("暱稱長度錯誤");
    }
    var id6 = document.getElementById("zid");
    var reg = new RegExp(/^\d{15}$|^(\d{18}|\d{17}[xX])$/);
    var id2 = id6.value;
    if (reg.test(id2)) {
        alert("id正確");
    } else {
        alert("id錯誤");
    }
    alert("恭喜您註冊成功");
}

function open_win() {
    window.open("login.html")
}