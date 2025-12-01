package cn.fjzzit.services;

import cn.fjzzit.dao.GradeDao;
import cn.fjzzit.pojo.Grade;

public class GradeService {
    GradeDao gradeDao = new GradeDao();

    public Grade getGradeById(int id) {
        return gradeDao.getGradeById(id);
    }
}
