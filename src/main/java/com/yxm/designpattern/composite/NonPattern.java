package com.yxm.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yexinming
 * @date 2020/3/19
场景：
（1）父部门->子部门->子部门
（2）我们要对部门树，删除一个父部门以及其下所有的子部门
 **/
public class NonPattern {

    public static void main(String[] args) {
       //1.父节点  
        Department parentDept = new Department("父部门");
        
        //2.子节点  
        Department subDept1 = new Department("子部门1");
        Department subDept2 = new Department("子部门2");

        //3.孙子节点
        Department leafDept1 = new Department("叶子部门1");
        Department leafDept2 = new Department("叶子部门2");
        Department leafDept3 = new Department("叶子部门3");

        //4.数据组装
        subDept1.getChildren().add(leafDept1);
        subDept1.getChildren().add(leafDept2);
        subDept2.getChildren().add(leafDept3);

        parentDept.getChildren().add(subDept1);
        parentDept.getChildren().add(subDept2);

        //5.删除
        for (Department subDept:parentDept.getChildren()){
            if(subDept.getChildren().size()>0){
                for (Department leafDept:subDept.getChildren()){
                    leafDept.remove();
                }
            }
            subDept.remove();
        }
        parentDept.remove();
    }

     public static class Department{
         private String name;
         private List<Department> children = new ArrayList<Department>();

         public Department(String name){
             this.name = name;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public List<Department> getChildren() {
             return children;
         }

         public void setChildren(List<Department> children) {
             this.children = children;
         }
         public void remove(){
             System.out.println("删除部门【" + name + "】");
         }
     }
}
