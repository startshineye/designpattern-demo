package com.yxm.designpattern.adapter;

/**
 * @author yexinming
 * @date 2020/3/14
 * 场景介绍：
 * （1）假设我们做了一个第一版的一个系统，这个系统里有一个接口和一个实现类
 * （2）接着我们开始做第二版的系统，这个系统我们定义了一个新的接口，和新的实现类
 * （3）但是我们同时在第二版的系统中，也要使用第一版系统中定义的那个老接口和老实现类
 **/
public class NonPatternApplication {
    public static void main(String[] args) {
        OldInterface oldInterface = new OldInterfaceImpl();
        NewInterface newInterface = new NewInterfaceImpl();

        oldInterface.oldRun();
        newInterface.newRun();

        /**
         * 如果不使用任何涉及模式，我们的问题在哪?
         * 问题其实很显然,就是说,我们的新代码中，面向的是规范和风格完全不同的两套接口，你理解和维护的成本提高了
         * 其次，假如说，现在都不给你选择使用老版本接口的机会
         * 直接强制性公司规范要求按照新版本接口来走，你的老版本接口的实现类，就没法用了啊？
         * 难不成还要基于新版本的接口重新写一套？
         */
    }


    //===============接口====================
    // 老版本接口
    public static interface OldInterface{
        void oldRun();
    }

    //新版本接口
    public static interface NewInterface{
        void newRun();
    }
    //================实现类====================
    public static class OldInterfaceImpl implements OldInterface{
        public void oldRun() {
            System.out.println("老版本功能逻辑");
        }
    }

    public static class NewInterfaceImpl implements NewInterface{
        public void newRun() {
            System.out.println("新版本功能逻辑");
        }
    }

}
