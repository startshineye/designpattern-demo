package com.yxm.designpattern.abstractfactory;

/**
 * @author yexinming
 * @date 2020/3/16
场景：
（1）就是我们现在要生产的不是一个一个产品，而一个一个的产品组合
（2）比如说我们有产品AB，现在第一种产品组合是A1+B1，第二种产品组合是A2+B2，第三种产品组合是A3+B3
（3）就是要对工厂模式进行进一步的增强
 **/
public class NonPattern {
    public static void main(String[] args) {
        //第一种产品组合:A1+B1
        ProductA firstProductA1 = new ProductA1();
        ProductB firstProductB1 = new ProductB1();
        firstProductA1.excute();
        firstProductB1.excute();

        //第二种产品组合:A2+B2
        ProductA secondProductA2 = new ProductA2();
        ProductB secondProductB2 = new ProductB2();
        secondProductA2.excute();
        secondProductB2.excute();

        //第三种产品组合:A3+B3
        ProductA thirdProductA3 = new ProductA3();
        ProductB thirdProductB3 = new ProductB3();
        thirdProductA3.excute();
        thirdProductB3.excute();

        /**
         * // 问题来了，调整产品组合的这个行为，如果你手动创建产品组合的代码，有100个地方，A1+B1
         * 		// 一旦要调整，可能产品组合1位:A1+A3 就是要对100个地方的代码，手动一点一点的去修改，组合的逻辑
         * 		// 不可维护，不可扩展
         */
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

    public static class ProductA1 implements ProductA{

        public void excute() {
            System.out.println("产品A1的功能逻辑");
        }
    }

    public static class ProductA2 implements ProductA{

        public void excute() {
            System.out.println("产品A2的功能逻辑");
        }
    }

    public static class ProductA3 implements ProductA{

        public void excute() {
            System.out.println("产品A3的功能逻辑");
        }
    }

    public static class ProductB1 implements ProductB{

        public void excute() {
            System.out.println("产品B1的功能逻辑");
        }
    }
    public static class ProductB2 implements ProductB{

        public void excute() {
            System.out.println("产品B2的功能逻辑");
        }
    }
    public static class ProductB3 implements ProductB{

        public void excute() {
            System.out.println("产品B3的功能逻辑");
        }
    }

}
