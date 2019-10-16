<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
<table id="categoryTable" lay-filter="categoryTableFilter"></table>
<!--==============表头工具栏  start=================-->
<script type="text/html" id="p">
    <a lay-event="product" class="layui-btn layui-btn-sm">图书列表</a>
</script>
<!--==============表头工具栏  end=================-->
<script type="text/javascript">
    layui.use(['table','layer'],function () {
        var table = layui.table;
        var $ = layui.$;
        table.render({
            elem:"#categoryTable",
            url:"category/select",
            page:true,
            toolbar:'#p',
            cols:[[
                {title:"编号",field:"category_id"},
                {title:"名称",field:"category_name"},
                {title:"所属类别",field:"category_type"},
                {title:"图书数量",field:"count"}
            ]]
        })
        table.on('toolbar(categoryTableFilter)',function (obj) {
            window.location.href="productlist.html";
        })
    })
</script>
</body>
</html>
