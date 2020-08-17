
// id password
// id btSubmit
// id nickname

window.onload = function(){
	$("#btsubmit").on("click", function(){
		const value = $("#account").val();
		const value1 = $("#password").val();
		const obj = {account: value, password: value1};
		const jsonObj = JSON.stringify(obj);
		alert(jsonObj);
		
		fetch("../../LoginController", {
		method: "POST",
		headers: { "Content-Type": "application/json" },
		body: JSON.stringify(obj)
	})
		.then(resp => resp.json())
		.then(body => {
			// 接收到Controller回應後，要做的事寫在這!!
			alert(body.nickName);
		}); 
	});
}	
//		$.ajax({
//		    url: '../UseJsonServlet', // 將資料傳送出去的網址
//		    type: 'post',                                            // 也可以是 post
//		    contentType: "application/json",
//		    data: jsonObj,                              // 傳遞的參數
//		    dataType: 'json',                                       // 傳回來的資料類型
//		    success: function(data){                                // 成功接收到資料後，會執行的函式
//		     alert(html(data.value));
//		     // $("#get_data").html(data.value);
//		    },
//		    statusCode: {                                           // 依據伺服器端回傳的狀態碼，來顯示錯誤訊息
//		      500: function() {
//		        alert( "500 伺服器端錯誤" );
//		      }
//		    }
//		  });
