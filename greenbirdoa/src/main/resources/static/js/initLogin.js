//不写function代表页面加载就启动
var div=document.getElementById("initLogin");
$.ajax({
    url: "/user/status",   //请求的url
    type: "post",               //请求方式get，post
    data:null,                  //传递给服务器的数据
    dataType: "json",           //返回的数据类型为文本
    success: function(data){
        if(data.returnIsTrue=="false"){
            alert("尚未登录,请重新登录");
            window.location.href="page-login.html";
        }else{
            div.innerHTML="欢迎"+data.userDepart+data.userName+"登录<br><a href='#' onclick='loginout()'>注销</a>";
            if(data.userToDayIsSignin=="true"){
                $("#isSignin").html("已签到");
            }else{
                $("#isSignin").html("未签到请及时签到");
            }
        }
    },                          
    error: function (data) {    
        alert("与服务器连接出错!");
    }
});

function loginout(){
	$.ajax({
	    url: "/user/logout",   //请求的url
	    type: "post",               //请求方式get，post
	    data:null,                  //传递给服务器的数据
	    dataType: null,           	//返回的数据类型为文本
	    success: function (){
	    	alert("注销成功返回登录页面");
	    	window.location.href="page-login.html";
	    },
	    error: function (data) {    
	        alert("与服务器连接出错!");
	    }
	});
}
