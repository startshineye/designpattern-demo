package com.yxm.designpattern.iterator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 不用模式实现
 * @author yxm
 * @date 2020/3/14
 **/
public class NonPattern {

    public static void main(String[] args) {
        //1.不使用设计模式情况下遍历聚合类中数据
        Student stu1 = new Student("小明");
        Student stu2 = new Student("小王");

        //=========================聚合类遍历一=========================
        /*Student[] students = new Student[2];
        students[0]=stu1;
        students[1]=stu2;

        Classroom classroom = new Classroom();  
        classroom.setStudents(students);
         Student[] classroomStudents = classroom.getStudents();
        for(Student stu:classroomStudents){
            System.out.println(stu);
        }

        */

        //=========================聚合类遍历二=========================
        Map<String, Student> mapStudents = new HashMap<String, Student>();
        mapStudents.put(stu1.getName(),stu1);
        mapStudents.put(stu2.getName(),stu2);
        Classroom classroom = new Classroom();
        classroom.setStudents(mapStudents);

        Map<String, Student> classroomStudents = classroom.getStudents();
        for(Student stu:classroomStudents.values()){
            System.out.println(stu);
        }
    }
    public static class Classroom{
        private Map<String,Student> students;

        public void setStudents(Map<String,Student> students){
            this.students = students;
        }

        public Map<String,Student> getStudents(){
            return this.students;
        }
    }
    /**
     * 教室类
     */
   /* public static class Classroom{
        private Student[] students;

        public void setStudents(Student[] students){
            this.students = students;
        }

        public Student[] getStudents(){
            return this.students;
        }
    }*/
    /**
     * 学生类
     */
    public static class Student{
        private String name;

        public Student(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
