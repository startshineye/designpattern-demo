package com.yxm.designpattern.chain;

/**
 * @author yexinming
 * @date 2020/3/21
场景：
（1）现在在某一个地方的业务流程，要执行功能A、功能B、功能C
（2）现在在另外一个地方的业务流程，是要先执行功能C，然后执行功能A和功能B
 **/
public class NonPattern {
    public static void main(String[] args) {
        //业务流程一
        System.out.println("执行功能A");
        System.out.println("执行功能B");
        System.out.println("执行功能C");

        //业务流程二
        System.out.println("执行功能C");
        System.out.println("执行功能A");
        System.out.println("执行功能B");
        /**
         * 问题:
         * 1.大量重复代码出现,功能A,B,C的代码出现在业务流程A,业务流程B，有复制粘贴的现象。
         * 对某个功能的代码进行修改，那么就会很麻烦，要在多个地方去修改这个功能的代码
         * 2.对某个业务流程的顺序进行调整或者改造，很麻烦，要去修改大量的代码
         */
    }
}
