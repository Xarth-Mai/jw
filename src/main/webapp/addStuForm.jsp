<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加学生</title>
</head>
<body>
    <h2>添加学生</h2>
    <form action="doAddStu.jsp" method="post">
        <p>学号：<input type="number" name="studentNo" required></p>
        <p>姓名：<input type="text" name="name" required></p>
        <p>密码：<input type="password" name="pwd" required></p>
        <p>性别：
            <label><input type="radio" name="sex" value="男" checked>男</label>
            <label><input type="radio" name="sex" value="女">女</label>
        </p>
        <p>年级ID：<input type="number" name="gradeId" required placeholder="例如：1"></p>
        <p>生日：<input type="date" name="born" required></p>
        <p>邮箱：<input type="email" name="email"></p>
        <p>照片路径：<input type="text" name="photo"></p>
        <p><button type="submit">提交</button></p>
    </form>
    <p><a href="student2.jsp">返回列表</a></p>
</body>
</html>
