package com.yxm.designpattern.prototype;

/**
 * @author yexinming
 * @date 2020/3/19
场景:
如果一个对象，我们希望拷贝一个这个对象，
就是弄出来这个类的另外一个实例，
实例的属性跟之前的实例是一模一样的
 **/
public class PrototypePattern {
    public static void main(String[] args) {
        try {
            //1. 创建一个对象,进行拷贝
            Product product = new Product("测试产品", new Component("测试组件"));

            //2.拷贝一个新对象
            Object copyedProduct = product.clone();

            System.out.println("原对象为:"+product);
            System.out.println("新对象为:"+copyedProduct);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //=====================产品类======================
    public static class Product{
        private String name;
        private Component component;

        public Product(String name,Component component){
            this.name=name;
            this.component =component;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Component getComponent() {
            return component;
        }

        public void setComponent(Component component) {
            this.component = component;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            //浅拷贝，就是我们现在的一个实现 就是仅仅简单的对当前所有的变量进行一个拷贝
           // return new Product(getName(),getComponent());

            // 深考别，递归对自己引用的对象也进行拷贝
             return new Product(getName(),(Component) getComponent().clone());
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", component=" + component +
                    '}';
        }
    }


    public static class Component{
        private String name;
        public Component(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Component{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Component(getName());
        }
    }
}
