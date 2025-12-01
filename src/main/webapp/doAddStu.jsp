<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cn.fjzzit.services.*" %>
<%@ page import="cn.fjzzit.pojo.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    request.setCharacterEncoding("UTF-8");
    try {
        // 1. 接收参数
        String noStr = request.getParameter("studentNo");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String gradeIdStr = request.getParameter("gradeId");
        String bornStr = request.getParameter("born");
        String email = request.getParameter("email");
        String photo = request.getParameter("photo");

        // 2. 简单验证
        if (noStr == null || name == null || gradeIdStr == null || bornStr == null) {
            out.print("<script>alert('参数不完整');history.back();</script>");
            return;
        }

        // 3. 数据封装
        Student stu = new Student();
        stu.setStudentNo(Integer.parseInt(noStr));
        stu.setStudentName(name);
        stu.setLoginPwd(pwd);
        stu.setSex(sex);
        
        GradeService gs = new GradeService();
        Grade g = gs.getGradeById(Integer.parseInt(gradeIdStr));
        if(g == null) {
             out.print("<script>alert('年级ID不存在');history.back();</script>");
             return;
        }
        stu.setGrade(g);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stu.setBornDate(new java.sql.Date(sdf.parse(bornStr).getTime()));
        stu.setEmail(email);
        stu.setPhoto(photo);

        // 4. 调用业务层
        StudentService ss = new StudentService();
        boolean isSuccess = ss.addStu(stu);

        // 5. 响应结果
        if (isSuccess) {
            out.print("<script>alert('添加成功'); window.location='student2.jsp';</script>");
        } else {
            out.print("<script>alert('添加失败：学号可能已存在'); history.back();</script>");
        }

    } catch (Exception e) {
        e.printStackTrace();
        out.print("<script>alert('系统错误：" + e.getMessage() + "'); history.back();</script>");
    }
%>
