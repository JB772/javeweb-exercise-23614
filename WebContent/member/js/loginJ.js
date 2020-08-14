
// id password
// id btSubmit
// id nickname

window.onload = function(){
	$("#btSubmit").on("click", function(){
		  const account = $("#account").val();
		  console.log(account);
//		  const reg = new RegExp(/^\w{6,20}$/);
//			    if (n != null && reg.test(account)) {
//			        alert("account correct!");
//			    } else {
//			        alert("please enter Account again!");
//			    }
		  const password = $("#password").val();
		  console.log(password);
//		  const reg1 = new RegExp(/^[a-zA-Z0-9_-]{6,16}$/);
//			    if (n != null && reg1.test(password)) {
//			        alert("password correct!");
//			    } else {
//			        alert("password error!");
//			    }
//		  const nickname = $("nickname").val();
//		  const reg2 = new RegExp(/^\w{5,20}$/);
//			    if (account == reg == reg2 && reg1 == password && reg2 == nickname) {
//			        alert("登陸成功");
//			    }
//			    const obj = {account: account, password: password};
		  jsonObj= [];
		  member={};
		  member["account"]=account;
		  member["password"]=password;
		  jsonObj.push(member);
		  
		      fetch("./UseJsonServlet", {
		        method: "POST",
		        headers: { "Content-Type": "application/json" },
		        body: JSON.stringify(jsonObj)
		      })
		      .then(resp => resp.json())
		      .then(body => {
		    // 接收到Controller回應後，要做的事寫在這!!
		    	  alert(body.lastUpdateDate);
		      });
		});
};
