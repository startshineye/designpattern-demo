package com.yxm.designpattern.factorymethod;

/**
 * @author yexinming
 * @date 2020/3/15
场景：
（1）我们现在要生产的产品有多种
（2）每种产品的生产过程，都有一些是共同的逻辑，但是也有一些是特殊的逻辑
（3）现在要生产出来各种产品
*/
public class NonPattern {
    public static void main(String[] args) {
        //我们使用工厂模式生产3种产品
        Prodeuct prodeuct1 = ProductFactory1.create();
        Prodeuct prodeuct2 = ProductFactory2.create();
        Prodeuct prodeuct3 = ProductFactory3.create();

        prodeuct1.excute();
        prodeuct2.excute();
        prodeuct3.excute();

        // 问题在哪儿？
        // 跟模板方法模式的问题一模一样
        // 就是多个工厂类中，有生产产品的相同的通用逻辑，没有抽取出来，直接复制粘贴放多个工厂里了
        // 如果那段通用逻辑要修改
        // 就需要很麻烦到所有工厂中去修改代码；可能会忘记修改某个工厂的代码
    }



    //====================产品工厂======================
    public static class ProductFactory1{
        public static Prodeuct create(){
            return new Product1();
        }
    }

    public static class ProductFactory2{
        public static Prodeuct create(){
            return new Product2();
        }
    }

    public static class ProductFactory3{
        public static Prodeuct create(){
            return new Product3();
        }
    }
    //=====================具体产品类======================
    public interface Prodeuct{
        void excute();
    }

    public static class Product1 implements Prodeuct{
        public void excute() {
            System.out.println("生产产品通用逻辑");
            System.out.println("生产产品1特有逻辑");
        }
    }

    public static class Product2 implements Prodeuct{

        public void excute() {
            System.out.println("生产产品通用逻辑");
            System.out.println("生产产品1特有逻辑");
        }
    }

    public static class Product3 implements Prodeuct{

        public void excute() {
            System.out.println("生产产品通用逻辑");
            System.out.println("生产产品3特有逻辑");
        }
    }

}
