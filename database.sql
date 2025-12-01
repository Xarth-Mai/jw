CREATE DATABASE IF NOT EXISTS student_db DEFAULT CHARSET utf8mb4;
USE student_db;

-- 年级表
CREATE TABLE grade (
    gradeId INT PRIMARY KEY AUTO_INCREMENT,
    gradeName VARCHAR(50) NOT NULL
);

-- 学生表
CREATE TABLE student (
    studentNo INT PRIMARY KEY,
    studentName VARCHAR(50) NOT NULL,
    loginPwd VARCHAR(50) NOT NULL,
    sex CHAR(2) DEFAULT '男',
    gradeId INT,
    bornDate DATE,
    email VARCHAR(100),
    photo VARCHAR(255),
    FOREIGN KEY (gradeId) REFERENCES grade(gradeId)
);

-- 初始化测试数据
INSERT INTO grade (gradeId, gradeName) VALUES (1, '一年级'), (2, '二年级'), (3, '三年级');
