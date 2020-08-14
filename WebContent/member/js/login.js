function de() {
    var Account = document.getElementById("Account");
    var account = Account.value;
    var reg = new RegExp(/^\w{6,20}$/);
    if (n != null && reg.test(account)) {
        alert("姓名正確");
    } else {
        alert("重新輸入");
    }
    var pwd = document.getElementById("pwd");
    var password = pwd.value;
    var reg1 = new RegExp(/^[a-zA-Z0-9_-]{6,16}$/);
    if (n != null && reg1.test(password)) {
        alert("密碼正確");
    } else {
        alert("密碼錯誤");
    }
    var nickName = document.getElementById("nickname");
    var nickname = nickName.value;
    var reg2 = new RegExp(/^\w{5,20}$/);
    if (account == reg == reg2 && reg1 == password && reg2 == nickname) {
        alert("登陸成功");
    }
    const obj = {account: acount, password: password};
    
    fetch("./UseJsonServlet", {
    	
    	method: "POST",
    	headers: { "Content-Type": "application/json" },
    	body: JSON.stringify(obj)
    })
    	.then(resp => resp.json())
    	.then(body => {
    		// 接收到Controller回應後，要做的事寫在這!!
    		alert(body.lastUpdateDate);
    	});
}