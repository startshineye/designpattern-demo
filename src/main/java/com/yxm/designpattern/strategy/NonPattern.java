package com.yxm.designpattern.strategy;

/**
 * @author yexinming
 * @date 2020/3/20
 * 场景:
 * (1):远行时候:我们根据不同的路程来选择不同的远行车类型
 **/
public class NonPattern {
    public static void main(String[] args) {
        /**
         *有一个参数，是distanceType
         * 如果这个参数1，那么选择远行车类型A
         * 如果这个参数2，那么选择远行车类型B
         * 	如果这个参数3，那么选择远行车类型C
         */
        int distanceType = 1;
        if (distanceType==1){
            System.out.println("远行车类型A");
        }else if(distanceType == 2){
            System.out.println("远行车类型B");
        }else if(distanceType == 3){
            System.out.println("远行车类型C");
        }else {
            System.out.println("远行车默认类型");
        }
        /**
         * 实际上在我们的业务代码，if else，看起来绝对不是这么短的，也不是这么简单
         * 在实际的业务代码中，常见的结构是上面这样的，但是每个if和if else之间的代码行数，可能多达几十行，甚至几百行
         * 	if和else if的判断条件，很模糊，经常就是用一堆变量的比较来判断，是走哪个分支
         *
         * 类似上面这样的代码，会让我们在代码写好以后，1年之后，回过头来看这个代码，哇塞，看到了一坨屎一样
         * 看都看不懂了：代码太多了，if else if之后的条件判断，我们都看不懂，不知道在判断，if else if里面的代码，量太大了
         * 	定位个bug，疯了，或者是对这段代码的业务逻辑做一些改动，疯了
         * 基本上，你得花个一两天的时间，把这段代码重新读一遍，然后看懂，才能下手写代码
         *
         * 	拿10k的月薪的人,不代表说，市场给他10k的薪资，他就写一手漂亮代码
         * 	他拿着10k，15k，20k薪资的同学，也还算是从一些比较好的互联网公司过来的
         *
         * 	写出来了屎一样，没有任何面向对象的设计，大量的复杂业务逻辑就集中在少数一辆个类里面
         * 	每个类里面，大量的充斥着，一个方法几百行，上千行代码
         * 	大量的变量命名，int a = 1，if(b = 10)
         *  if else if else if else if else，大量这种垃圾
         *
         * 对自己没有任何追求，自己写一手烂代码，烂把，天气好，吃的好，日子好，跳槽重新是一条好汉
         */
    }
}
