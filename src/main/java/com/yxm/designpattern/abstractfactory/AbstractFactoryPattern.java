package com.yxm.designpattern.abstractfactory;

/**
 * @author yexinming
 * @date 2020/3/16
 **/
public class AbstractFactoryPattern {

        public static void main(String[] args) {
            // 产品A1+产品B1 -> 产品A1+产品B3
            ProductA firstProductA = Product1Factory.getInstance().createProductA();
            ProductB firstProductB = Product1Factory.getInstance().createProductB();
            firstProductA.excute();
            firstProductB.excute();

            // 产品A2+产品B2
            ProductA secondProductA = Product2Factory.getInstance().createProductA();
            ProductB secondProductB = Product2Factory.getInstance().createProductB();
            secondProductA.excute();
            secondProductB.excute();

            // 产品A3+产品B3
            ProductA thirdProductA = Product3Factory.getInstance().createProductA();
            ProductB thirdProductB = Product3Factory.getInstance().createProductB();
            thirdProductA.excute();
            thirdProductB.excute();
            // 哪怕你有100个地方定义了产品组合，要调整组合的逻辑，只要修改一个工厂就可以了

        }
        //我们使用抽象工厂模式:固定死了各个工厂创建的组合

        //如果需要改动产品:A1+B1的组合 为:A1+B3  我们只需要找到:产品组1（Factory1） 把之前的B1改为B3即可。其main方法中客户端调用不需要变动。
        // 哪怕你有100个地方定义了产品组合，要调整组合的逻辑，只要修改一个工厂就可以了


    //======================工厂模式=======================
    //我们需要创建3个组合,那么我们创建3个不同工厂,如果组合需要改变,我们叫工厂里面改变对应的 商品即可
    public interface Factory {
        ProductA createProductA();
        ProductB createProductB();
    }

    public static class Product1Factory implements Factory{

        private static final Product1Factory instance = new Product1Factory();

        public Product1Factory(){

        }
        public static Factory getInstance(){
            return instance;
        }

        public ProductA createProductA(){
            return new ProductA1();
        }

        public ProductB createProductB(){
            return new ProductB1();
        }
    }

    public static class Product2Factory implements Factory{
        private static final Product2Factory instance = new Product2Factory();

        public Product2Factory(){

        }
        public static Factory getInstance(){
            return instance;
        }

        public  ProductA createProductA(){
            return new ProductA2();
        }

        public  ProductB createProductB(){
            return new ProductB2();
        }
    }

    public static class Product3Factory implements Factory{
        private static final Product3Factory instance = new Product3Factory();

        public Product3Factory(){

        }

        public static Factory getInstance(){
            return instance;
        }

        public  ProductA createProductA(){
            return new ProductA3();
        }

        public  ProductB createProductB(){
            return new ProductB3();
        }
    }

    //==========================产品实体=====================
    public interface ProductA{
        void excute();
    };
    public interface ProductB{
        void excute();
    };
    public interface ProductC{
        void excute();
    };

    public static class ProductA1 implements ProductA {

        public void excute() {
            System.out.println("产品A1的功能逻辑");
        }
    }

    public static class ProductA2 implements ProductA {

        public void excute() {
            System.out.println("产品A2的功能逻辑");
        }
    }

    public static class ProductA3 implements ProductA {

        public void excute() {
            System.out.println("产品A3的功能逻辑");
        }
    }

    public static class ProductB1 implements ProductB {

        public void excute() {
            System.out.println("产品B1的功能逻辑");
        }
    }
    public static class ProductB2 implements ProductB {

        public void excute() {
            System.out.println("产品B2的功能逻辑");
        }
    }
    public static class ProductB3 implements ProductB {

        public void excute() {
            System.out.println("产品B3的功能逻辑");
        }
    }
}
