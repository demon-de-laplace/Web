//function checkUser(str){
	//if(str==""){
		//document.getElementById("div_user").innerHTML="请输入用户名!";
	//	document.getElementById(
		
		
//Ajax部分

var XMLHttpReq = false;

     //创建XMLHttpRequest对象      

function createXMLHttpRequest(){

        if(window.XMLHttpRequest) { //检测是否为Mozilla浏览器

                           try{

              XMLHttpReq = new XMLHttpRequest();

                        }catch(e){}

        }

        else if (window.ActiveXObject) { //检测是否为IE浏览器

            try {

                XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");

            } catch (e) {

                try {

                    XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");

                } catch (e) {}

            }

        }

    }

    //发送请求方法

    function sendRequest(url) {
    	
        createXMLHttpRequest();

        XMLHttpReq.open("GET", url, true); //建立对服务器的调用

        XMLHttpReq.onreadystatechange = processResponse;//指定响应处理函数

        XMLHttpReq.send(null);  // 发送请求

    }

    // 处理返回信息函数

    function processResponse() {

        if (XMLHttpReq.readyState == 4) { // 判断XMLHttpRequest对象是否已成功接收数据

            if (XMLHttpReq.status == 200) { // 请求成功
            	//window.alert("页面无错误");////////////////////////////////
            
                   checkUsernameCallback();     //调用处理函数         
                
            } else { //页面异常

                window.alert("页面有错误");

            }

        }

}

/*-------------------------------------------------------------------------------------------------------------------------*/

//验证用户名

var usernameFlag=false;
var passwordFlag=false;
var emailFlag=false;
function checkUsername(){

	var username=document.getElementById("username").value;
	var usernameMsg=document.getElementById("usernameMsg");
	
	if(username==""){
	
	  usernameFlag=false;
	
	  usernameMsg.innerHTML="<font color='red'>   × 请填写用户名</font>";
	
	}else{
	
	  usernameMsg.innerHTML="<image src='../images/process.gif'/>  正在检测…";
	
	  sendRequest("checkUsername.jsp?username="+encodeURI(username));
	  
	}

}
//回调函数
function checkUsernameCallback(){
	//window.alert("XMLHttpReq.responseText:"+XMLHttpReq.responseText);///////////////
	var json=eval('('+XMLHttpReq.responseText+')');
	var usernameMsg=document.getElementById("usernameMsg");

	if(json.msg==true){
		usernameFlag=true;
		usernameMsg.innerHTML="<font color='green'>   √ 用户名可用</font>";
	}else{
		usernameFlag=false;
		usernameMsg.innerHTML="<font color='red'>   × 用户名重复</font>";

	}

}

function  checkPassword(){
	var password=document.getElementById("password").value;
	var passwordMsg=document.getElementById("passwordMsg");
	checkRepassword();
	if(password.length < 6 || password.length > 14) {
		 passwordFlag=false;
		passwordMsg.innerHTML="<font color='red'>   × 密码长度应在6位-14位之间</font>";
	} else {
		passwordMsg.innerHTML="<font color='green'>   √</font>";
	}
}

function checkRepassword(){
	var password=document.getElementById("password").value;
	var repassword=document.getElementById("repassword").value;
	var repasswordMsg=document.getElementById("repasswordMsg");
	if(repassword==""){
		 passwordFlag=false;
		repasswordMsg.innerHTML="<font color='red'>   × 确认密码不能为空</font>";
	}
	else if(password == repassword){
		 passwordFlag=true;
		repasswordMsg.innerHTML="<font color='green'>   √</font>";
	} else {
		 passwordFlag=false;
		repasswordMsg.innerHTML="<font color='red'>   × 两次密码不一致</font>";
	}
}

function checkEmail(){
	var email=document.getElementById("email").value;
	var emailMsg=document.getElementById("emailMsg");
	var reg=/^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
	if(!reg.test(email)){
		 emailFlag=false;
		emailMsg.innerHTML="<font color='red'>   × 邮箱格式不正确</font>";
	} else {
		 emailFlag=true;
		emailMsg.innerHTML="<font color='green'>   √</font>";
	}
}
//注册表单提交验证
function register(){
	if(usernameFlag==true && passwordFlag==true && emailFlag==true){
	
	  window.alert("提交成功！");
	
	 // document.forms[0].submit();
	  return true;
	}else{
	
	  window.alert("您的信息不完整！");
	  return false;
	}

}

