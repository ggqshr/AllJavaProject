// JavaScript Document
var sum=0;
function add_num(lim,id)
{
	sum++;
	
	{
		var box=document.getElementById(id);
		var te=document.getElementById("aa");
		te.value=te.value+",f"+id;
		box.checked=true;
	}
	
}
function jian_num(lim,id)
{
	var box=document.getElementById(id);
	var te=document.getElementById("aa");
	if(sum!=0&&box.checked==true)
	{sum--;
	var char=",f"+id;
	box.checked=false;
	te.value=te.value.replace(char,"");
	}

	}