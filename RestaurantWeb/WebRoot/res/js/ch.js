// JavaScript Document
function check()
{
	var s1=document.getElementById("aa");
	var s2=document.getElementById("bb");
	
    if(s1.value==""|| s2.value=="")
	{
		alert("输入不能为空！请重新输入");
		s1.value="";
		s2.value="";
	}
	else
	{
			if(s1.value==s2.value)
		{
			alert("修改成功！请重新登陆");
			document.getElementById('form1').submit();
		}
		
		else 
		{
			alert("两次输入的密码不一样，请重新输入！");
		s1.value="";
		s2.value="";
		}
	}
}
