package cn.fjzzit.services;

import java.util.List;

import cn.fjzzit.dao.StudentDao;
import cn.fjzzit.pojo.Student;

public class StudentService {
    StudentDao studentDao = new StudentDao();

    public boolean addStu(Student student) {
        // 业务逻辑：检查学号是否重复
        if (studentDao.getStuById(student.getStudentNo()) == null) {
            return studentDao.addStu(student);
        }
        return false;
    }

    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }
}
