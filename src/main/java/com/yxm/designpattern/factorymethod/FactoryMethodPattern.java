package com.yxm.designpattern.factorymethod;

/**
 * @author yexinming
 * @date 2020/3/15
场景：
（1）我们现在要生产的产品有多种
（2）每种产品的生产过程，都有一些是共同的逻辑，但是也有一些是特殊的逻辑
（3）现在要生产出来各种产品
 **/
public class FactoryMethodPattern {

    public static void main(String[] args) {
        //创建实体
        Product product1 = Product1Factory.get().create();
        Product product2 = Product2Factory.get().create();
        Product product3 = Product3Factory.get().create();

       //执行
        product1.excute();
        product2.excute();
        product3.excute();

        /**
         * 说实话，这种设计模式算是较为复杂一点的了，
         * 适用的是比较复杂的场景了
         *
         * 一般就是在有复杂工厂生产场景的情况下，
         * 比如就是需要多种工厂生产不同的产品，
         * 但是产品都是类似的，同时不同的工厂有一定的相同逻辑，
         * 那么就用这种模式
         */
    }


    //=======================工厂======================
      public static class Product1Factory extends AbstractProductFactory{

        private static final Product1Factory instance = new Product1Factory();

        private Product1Factory() {

        }

        public static Product1Factory get() {
            return instance;
        }

        public Product specialExcute() {
            System.out.println("生产产品1的特殊逻辑");
            return new Product1();
        }
    }

    public static class Product2Factory extends AbstractProductFactory{

        private static final Product2Factory instance = new Product2Factory();

        private Product2Factory() {

        }

        public static Product2Factory get() {
            return instance;
        }

        public Product specialExcute() {
            System.out.println("生产产品2的特殊逻辑");
            return new Product2();
        }
    }

    public static class Product3Factory extends AbstractProductFactory{

        private static final Product3Factory instance = new Product3Factory();

        private Product3Factory() {

        }

        public static Product3Factory get() {
            return instance;
        }

        public Product specialExcute() {
            System.out.println("生产产品3的特殊逻辑");
            return new Product3();
        }
    }


    //=====================模板方法抽象父类=================================
    public static  abstract class  AbstractProductFactory{
        public Product create() {
          commonExcute();
          return specialExcute();
        }

        public void commonExcute(){
            System.out.println("生产产品通用逻辑");
        }

        //模板抽象方法---子类去覆盖
       public abstract Product specialExcute();
    }


    //=======================实体产品类==============================
    public interface Product{
        void excute();
    }

    public static class Product1 implements Product{

        public void excute() {
            System.out.println("生产产品1特有逻辑");
        }
    }
    public static class Product2 implements Product{
        public void excute() {
            System.out.println("生产产品2特有逻辑");
        }
    }
    public static class Product3 implements Product{
        public void excute() {
            System.out.println("生产产品3特有逻辑");
        }
    }
}
