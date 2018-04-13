var c=0,num=0;
function doCheck(obj,limit) 
{
obj.checked?c++:c--;
if(c>limit)
{ obj.checked=false; 
alert("最多选择"+limit+"个");
c--; } 
} 
