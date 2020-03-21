package com.yxm.designpattern.bridge;

/**
 * @author yexinming
 * @date 2020/3/21
 **/
public class BridgePattern {
    public static void main(String[] args) {
        ConcreteImplementor implementor = new ConcreteImplementor();
        RefinedAbstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.execute();

        /**
         * 桥接模式实现:
         * 1. implementor可以认为是一个代码组件，包含了一个接口和一个实现类
         * 2. abstraction可以认为是一个代码组件，包含了一个抽象类和一个子类
         * 3. abstraction要调用implementor的接口;在abstraction中包含了一个implementor的接口
         * 4.在abstraction调用implementor的时候，实际上是面向implementor接口去编程和调用的,只不过我们会将implementor的实现类实例传入abstraction中
         *
         * 桥接模式的桥:
         * abstraction调用implementor就是基于一个桥去调用的
         * 不是说abstraction直接仅仅面向implementor实现类去编程的，面向implementor接口去编程的
         *所以abstraction和implementor两个代码组件之间的桥，就是implementor接口
         *这个一个代码组件面向另外一个代码组件的接口来编程，就是将那个接口作为一个桥
         *
         * 桥接模式扩展:
         * 桥接模式，都不需要运用，java之中，无处不桥接
         * Java中面向接口编程就是无处不桥接。(mvc)
         */
    }


    //===============桥接模式（被调用方）:两个接口调用组装===============
    public interface Implementor{
        void execute();
    }
    public static class ConcreteImplementor implements Implementor{

        public void execute() {
            System.out.println("具体的实现");
        }
    }

    //==============桥接模式（调用方）：抽象类和实体类组装================
    public static abstract class Abstraction{
        protected Implementor implementor;

        public Abstraction(Implementor implementor){
            this.implementor = implementor;
        }

        public abstract void execute();//申明
    }

    public static class  RefinedAbstraction extends Abstraction{

        public RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }
        public void execute() {
           implementor.execute();
        }
    }
}
