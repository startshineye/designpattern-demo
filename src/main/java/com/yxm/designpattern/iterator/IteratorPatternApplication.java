package com.yxm.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yexinming
 * @date 2020/3/14
 **/
public class IteratorPatternApplication {
    public static void main(String[] args) {
        //1.构建聚合类
        Student stu1 = new Student("张三");
        Student stu2 = new Student("李四");

        Classroom classroom = new Classroom(2);
        classroom.addStudents(stu1);
        classroom.addStudents(stu2);

        //遍历
        Iterator iterator = classroom.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 代表了一个集合类(聚合类)接口
     */
    public interface Aggregate{
        public abstract Iterator iterator();
    }

    /**
     * 定义一个迭代器接口
     */
    public interface Iterator{
        public abstract boolean hasNext();
        public abstract  Object next();
    }

    public static class ClassroomIterator implements Iterator{
         private Classroom classroom;
         private int index;

         public ClassroomIterator(Classroom classroom){
             this.classroom = classroom;
             this.index = 0;
         }

        public boolean hasNext() {
             if(index<classroom.getLength()){
                 return true;
             }
             return false;
        }

        public Object next() {
            Student students = classroom.getStudents(this.index);
            index++;
            return students;
        }
    }

    /**
     * 教室类
     */
    public static class Classroom implements Aggregate{
       // private Student[] students;
        private List<Student> students;
        /**
         * last相当于是数组长度
         */
        private int last = 0;

        public Classroom(int size){
            //this.students= new Student[size];
            this.students = new ArrayList<Student>(2);
        }

        public Student getStudents(int index){
            //this.students[index];
            return this.students.get(index);
        }

        public void addStudents(Student  student){
            //this.students[last] = student;
            this.students.add(student);
            last++;
        }

        public int getLength(){
            return last;
        }

        public Iterator iterator() {
            ClassroomIterator classroomIterator = new ClassroomIterator(this);
            return classroomIterator;
        }
    }


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
