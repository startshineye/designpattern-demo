package com.yxm.designpattern.template;

/**
 * @author yexinming
 * @date 2020/3/15
 **/
public class TemplateMethodPattern {

    public static void main(String[] args) {
        CalculatePrice1 calculatePrice1 = new CalculatePrice1();
        CalculatePrice2 calculatePrice2 = new CalculatePrice2();
        CalculatePrice3 calculatePrice3 = new CalculatePrice3();

        calculatePrice1.calculate();
        calculatePrice2.calculate();
        calculatePrice3.calculate();

        //一旦我们修改通用逻辑时候,只需要修改通用类即可。

        //应该是最高频使用的设计模式，高频到了，我们都不用再这里举个什么例子了，
        // 因为在任何一个系统中，一定会出现说，多个类中都有相同的代码，
        // 此时就可以使用模板方法设计模式，将多个类中通用的逻辑抽取到一个父类中去
    }



    public interface CalculatePrice{
        void calculate();
    }

    public static abstract class AbstractCalculatePrice implements CalculatePrice{
        public void calculate() {
            //完成通用计算逻辑
            commonPrice();
            //完成特殊计算逻辑
            specificCalculate();
        }

       public void commonPrice(){
           System.out.println("通用的计算逻辑,修改了");
       }

       public abstract void specificCalculate();
    }


    public static class CalculatePrice1 extends AbstractCalculatePrice{

        public void specificCalculate() {
            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }

    public static class CalculatePrice2 extends AbstractCalculatePrice{

        public void specificCalculate() {
            System.out.println("优惠计算器2的特殊计算逻辑");
        }
    }

    public static class CalculatePrice3 extends AbstractCalculatePrice{

        public void specificCalculate() {
            System.out.println("优惠计算器3的特殊计算逻辑");
        }
    }
}
