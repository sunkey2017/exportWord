<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create word</title>

</head>
<body>
<h2 id="title">${datas.title}</h2>
 <div>
    <p>1.</p><p>散数据--</p>
    <p>作者：</p><p>${datas.author}</p>   
    <p>日期：</p><p>${datas.date}</p>     
    <table>
       <tr><td>型号</td><td>名称</td><td>电话</td></tr>
       <#list datas.tableData as d> 
       <tr><td>${d.xh}</td><td>${d.name}</td><td>${d.phone}</td></tr>
       </#list>
    </table>
 </div>
</body>
</html>