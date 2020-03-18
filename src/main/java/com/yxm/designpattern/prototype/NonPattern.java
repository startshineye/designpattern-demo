package com.yxm.designpattern.prototype;

/**
 * @author yexinming
 * @date 2020/3/19
场景:
    如果一个对象，我们希望拷贝一个这个对象，
    就是弄出来这个类的另外一个实例，
    实例的属性跟之前的实例是一模一样的
 **/
public class NonPattern {
    /**
     * 定义一个对象:里面有其他对象的引用,我们实现拷贝
     */
    public static void main(String[] args) {
        //1. 创建一个对象,进行拷贝
        Product product = new Product("测试产品", new Component("测试组件"));

        //2.手动来拷贝
        Product copyedProduct = new Product(product.getName(), product.getComponent());
        System.out.println("原对象:"+copyedProduct);
        System.out.println("拷贝了的对象:"+copyedProduct);

        /**
         * 问题是什么？
         * 代码的拷贝逻辑，是每个要拷贝的调用方(main方法)自己来实现的
         * 相同的拷贝逻辑会分散在很多不同的地方，如果拷贝逻辑改变了，多个调用的地方都要修改代码
         * 可维护性、可扩展性，很差
         */
    }




    //===================产品实体类====================
     public static class Product{
        private String name;
        private Component component;
        public Product(String name,Component component){
            super();
            this.name = name;
            this.component = component;
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
    }
}
