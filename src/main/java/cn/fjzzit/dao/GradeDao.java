package cn.fjzzit.dao;

import java.sql.SQLException;

import cn.fjzzit.pojo.Grade;

public class GradeDao extends BaseDao {
    public Grade getGradeById(int id) {
        Grade grade = null;
        String sql = "SELECT * FROM grade WHERE gradeId = ?";
        Object[] params = {id};
        try {
            rs = executeQuery(sql, params);
            if (rs != null && rs.next()) {
                grade = new Grade();
                grade.setGradeId(rs.getInt("gradeId"));
                grade.setGradeName(rs.getString("gradeName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(); // 查询完成后关闭
        }
        return grade;
    }
}
