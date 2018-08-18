package com.rpc.remoting.transporter;

import com.rpc.remoting.model.RemotingTransporter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhixiang.yuan
 * @description
 * @create 2018/08/18 20:48
 */
public class NettyTransporter {

    public static final byte STUDENTS = 1;
    public static final byte TEACHER = 2;

    public static void main(String[] args) {

        // 学生信息
        StudentInfos infos = new StudentInfos();
        RemotingTransporter studentsRemotingTransporter = RemotingTransporter.createRequestTransporter(STUDENTS, infos);
        // 老师信息
        TeacherInfo info = new TeacherInfo();
        RemotingTransporter teacherRemotingTransporter = RemotingTransporter.createRequestTransporter(TEACHER, info);

    }

    private static class StudentInfos implements CommonCustomBody {

        List<String> students = new ArrayList<String>();

        @Override
        public void checkFields() throws RemotingCommmonCustomException {
        }

        public List<String> getStudents() {
            return students;
        }

        public void setStudents(List<String> students) {
            this.students = students;
        }

    }

    private static class TeacherInfo implements CommonCustomBody {

        String teacher = "";

        @Override
        public void checkFields() throws RemotingCommmonCustomException {
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

    }


}
