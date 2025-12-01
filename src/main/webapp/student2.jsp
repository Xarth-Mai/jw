<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,cn.fjzzit.pojo.*,cn.fjzzit.services.*" %>
<!DOCTYPE html>
<html>
<head><title>学生列表</title></head>
<body>
    <h2>学生信息列表</h2>
    <a href="addStuForm.jsp">添加新学生</a>
    <table border="1" width="80%">
        <tr>
            <th>学号</th><th>姓名</th><th>性别</th><th>年级</th><th>操作</th>
        </tr>
        <%
            StudentService ss = new StudentService();
            List<Student> list = ss.getAllStudent();
            for(Student s : list) {
        %>
        <tr>
            <td><%=s.getStudentNo()%></td>
            <td><%=s.getStudentName()%></td>
            <td><%=s.getSex()%></td>
            <td><%=s.getGrade() != null ? s.getGrade().getGradeName() : "未知"%></td>
            <td>删除 | 修改</td>
        </tr>
        <% } %>
    </table>
</body>
</html>
