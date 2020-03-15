package com.yxm.designpattern.factory;

/**
 * @author yexinming
 * @date 2020/3/15
场景:
我们创建对象,简单工厂模式采用面向接口编程
接口是从多个相似类中抽象出来的规范，接口体现了规范（设计）和实现分离的设计哲学，接口本身并不提供任何实现。
 **/
public class FactoryPattern {

    public static void main(String[] args) {
        //1.产品1
        Product product = ProductFactory.create();
        product.execute();

        // 如果此时有100个地方都需要获取Product的实例
        // 但是此时Product实现类改了
        // 我们只要修改一个地方即可，就是ProductFacory中

        //但是此时客户端调用一直没变味。面向接口编程。    
    }


    //我们把传统模式下的类变成接口，如果我们想要创建可变的对个产品实现类,其对应的接口不变,那么业务逻辑也不会改变

    public interface Product{
        void execute();
    }

    public static class ProductFactory{
        public static Product create(){
            return new ProductImpl2();
        }
    }

    public static class ProductImpl1 implements Product {
        public void execute() {
            System.out.print("产品1的功能实现");
        }
    }

    public static class ProductImpl2 implements Product {
        public void execute() {
            System.out.print("产品2的功能实现");
        }
    }
}
