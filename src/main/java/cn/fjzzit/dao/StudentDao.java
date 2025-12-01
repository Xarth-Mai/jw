package cn.fjzzit.dao;

import java.util.ArrayList;
import java.util.List;

import cn.fjzzit.pojo.Student;

public class StudentDao extends BaseDao {

    // 查询所有学生
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try {
            // 注意：此处存在N+1性能问题，但在本实训任务中保留原逻辑
            GradeDao gradeDao = new GradeDao();
            rs = executeQuery(sql, null);
            while (rs.next()) {
                Student s = new Student();
                s.setStudentNo(rs.getInt("studentNo"));
                s.setStudentName(rs.getString("studentName"));
                s.setLoginPwd(rs.getString("loginPwd"));
                s.setSex(rs.getString("sex"));
                s.setBornDate(rs.getDate("bornDate"));
                s.setEmail(rs.getString("email"));
                s.setPhoto(rs.getString("photo"));
                s.setGrade(gradeDao.getGradeById(rs.getInt("gradeId")));
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return students;
    }

    // 根据ID查询 (用于查重)
    public Student getStuById(int id) {
        Student s = null;
        String sql = "SELECT * FROM student WHERE studentNo = ?";
        Object[] params = {id};
        try {
            rs = executeQuery(sql, params);
            if (rs != null && rs.next()) {
                s = new Student();
                s.setStudentNo(rs.getInt("studentNo"));
                // 仅用于判断是否存在，无需填充所有字段
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return s;
    }

    // 添加学生 (核心任务)
    public boolean addStu(Student s) {
        String sql = "INSERT INTO student(studentNo, studentName, loginPwd, sex, gradeId, bornDate, email, photo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {
            s.getStudentNo(),
            s.getStudentName(),
            s.getLoginPwd(),
            s.getSex(),
            s.getGrade().getGradeId(),
            s.getBornDate(),
            s.getEmail(),
            s.getPhoto()
        };
        return executeUpdate(sql, params) > 0;
    }

    // 删除学生
    public boolean delStuById(int id) {
        String sql = "DELETE FROM student WHERE studentNo = ?";
        Object[] params = {id};
        return executeUpdate(sql, params) > 0;
    }
    
    // 修改学生
    public boolean editStu(Student s) {
        String sql = "UPDATE student SET studentName=?, loginPwd=?, sex=?, gradeId=?, bornDate=?, email=?, photo=? WHERE studentNo=?";
        Object[] params = {
            s.getStudentName(), s.getLoginPwd(), s.getSex(),
            s.getGrade().getGradeId(), s.getBornDate(), s.getEmail(),
            s.getPhoto(), s.getStudentNo()
        };
        return executeUpdate(sql, params) > 0;
    }
}
