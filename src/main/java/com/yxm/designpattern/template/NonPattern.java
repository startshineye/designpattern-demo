package com.yxm.designpattern.template;

/**
 * @author yexinming
 * @date 2020/3/15
场景：
（1）我们有多种优惠策略
（2）不同的优惠策略在计算的价格的时候，有一些通用的基础逻辑
（3）每种优惠策略还有一些是自己特殊的价格计算的逻辑
*/
public class NonPattern {

    public static void main(String[] args) {
        CalculatePrice1 calculatePrice1 = new CalculatePrice1();
        calculatePrice1.calculate();

        CalculatePrice2 calculatePrice2 = new CalculatePrice2();
        calculatePrice2.calculate();

        CalculatePrice3 calculatePrice3 = new CalculatePrice3();
        calculatePrice3.calculate();

        // 有一个问题
        // 就是说，这个三种优惠方式计算器里面，都有一段通用的计算逻辑，是完全相同的代码
        // 但是相同的一段代码，通过复制粘贴的方式，放到了不同的类里去
        // 一旦那段通用的计算逻辑，要修改，就涉及到多个类都要去修改那个代码
        // 如果你一旦忘了修改某个类中的那段代码，后果不堪设想
        // 而且到了后期，几乎没人记得清楚，那段通用逻辑代码放在了多少个类中，如果要排查，需要将很多类重新读一遍代码
        // 这就是垃圾代码，扩展性，维护性，很烂
    }

    public static class CalculatePrice1{
        public void calculate(){
            System.out.println("通用的计算逻辑");
            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }

    public static class CalculatePrice2{
        public void calculate(){
            System.out.println("通用的计算逻辑");
            System.out.println("优惠计算器2的特殊计算逻辑");
        }
    }

    public static class CalculatePrice3{
        public void calculate(){
            System.out.println("通用的计算逻辑");
            System.out.println("优惠计算器3的特殊计算逻辑");
        }
    }
}
