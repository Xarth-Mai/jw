package cn.fjzzit.pojo;

import java.sql.Date;

public class Student {
    private int studentNo;
    private String studentName;
    private String loginPwd;
    private String sex;
    private Grade grade;
    private Date bornDate;
    private String email;
    private String photo;

    public Student() {}

    public Student(int studentNo, String studentName, String loginPwd, String sex, Grade grade, Date bornDate, String email, String photo) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.loginPwd = loginPwd;
        this.sex = sex;
        this.grade = grade;
        this.bornDate = bornDate;
        this.email = email;
        this.photo = photo;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
