<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 10:07
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
<form class="layui-form" id="userForm" lay-filter="userForm">
    <div class="layui-form-item" >
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="nickname" required  lay-verify="required" placeholder="请输入用户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" >
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password"  required  lay-verify="required" placeholder="请输入密码" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item" >
        <label class="layui-form-label">验证码</label>
        <div class="layui-input-inline">
            <input type="text" name="code" required  lay-verify="required" placeholder="请输入验证码" class="layui-input">
            <img src="${pageContext.request.contextPath}/code/val">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="login">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript">
    layui.use(['form','layer'],function () {
        var form = layui.form;
        var $ = layui.$;
        form.on('submit(login)',function () {
            $.ajax({
                url:'user/login',
                data:$("#userForm").serialize(),
                type:'post',
                dataType:'json',
                success:function (r) {
                    if(r.login === '验证码错误'){
                        layer.msg("验证码错误")
                    }else if(r.login){
                        layer.msg("登陆成功")
                        window.location.href="productlist.html"
                    }else {
                        layer.msg("用户名或密码错误")
                    }
                }
            })
            return false;
        })
    })
</script>
</body>
</html>
