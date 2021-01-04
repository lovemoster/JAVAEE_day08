<%--
  Created by IntelliJ IDEA.
  User: Shadow
  Date: 2021/1/4
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索省份信息</title>
</head>
<body>
<table border="1" cellspacing="0.5">
    <tbody>
    <tr>
        <td>省份编号：</td>
        <td>
            <input type="text" id="shengfenid">
            <input type="button" value="查询" onclick="search()">
        </td>
    </tr>
    <tr>
        <td>省份名称：</td>
        <td id="shenfenminchen"></td>
    </tr>
    <tr>
        <td>省份简称：</td>
        <td id="shenfenjiancheng"></td>
    </tr>
    <tr>
        <td>省会：</td>
        <td id="shenhui"></td>
    </tr>
    </tbody>
</table>
</body>
<script>
    function callback(data) {
        document.getElementById('shenfenminchen').innerText = data.name;
        document.getElementById('shenfenjiancheng').innerText = data.jiancheng;
        document.getElementById('shenhui').innerText = data.shenghui;
    }

    function search() {
        //创建异步请求对象
        let xml = new XMLHttpRequest();
        //侦听请求状态
        xml.onreadystatechange = function () {
            //判断是否从服务器收到合法的响应
            if (xml.readyState === 4 && xml.status === 200) {
                let obj = xml.responseText;
                let data = eval('(' + obj + ')');
                //执行回调函数
                callback(data);
            }
        }
        //获取连接
        let province_id = document.getElementById('shengfenid').value;
        xml.open('get', 'queryProvinceById?id=' + province_id, true);
        //发送请求
        xml.send();
    }
</script>
</html>
