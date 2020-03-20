package com.yxm.designpattern.chain;

/**
 * @author yexinming
 * @date 2020/3/21
 **/
public class ChianPattern {
    public static void main(String[] args) {
        //1.业务流程1:功能A->功能B->功能C=========构建时候类似于链条
        Handler thirdHandler = new HandlerC(null);
        Handler secondHandler = new HandlerB(thirdHandler);
        Handler firstHandler = new HandlerA(secondHandler);
        firstHandler.execute();

        //2.业务流程2:功能C->功能A-->功能B=========构建时类似于链条
        thirdHandler = new HandlerB(null);
        secondHandler = new HandlerA(thirdHandler);
        firstHandler = new HandlerC(secondHandler);
        firstHandler.execute();



        /**
         * 责任链模式思想:
         * 1.将一个业务流程中的多个步骤拆分出来,每一个步骤封装到一个Handler处理器之中
         * 2.业务流程基于handler动态组装,不同的业务流程->handler代表的代码组件可以复用
         *
         *
         * 责任链模式好处:
         * 1.将某个关键步骤封装到一个handler中,后面如果要对某个步骤的代码逻辑进行调整,修改一个handler即可
         * 2.如果业务流程要修改,那么不需要拷贝大量代码,只要基于handler动态组装流程即可
         *
         *
         *  责任链模式场景:
         *  有多个业务流程,每个业务流程有相同的代码逻辑和步骤
         *  可以用责任链模式来实现
         */
    }

    //========================handler封装==========================
     public static abstract class Handler{
        protected Handler successor;
        /**
         * 抽象类构造器主要是给属性初始化的
         * @param successor
         */
        public Handler(Handler successor){
            System.out.println("==========abstract  Constructor==================start");
            this.successor = successor;
            System.out.println("==========abstract successor Fields=================="+successor);
            System.out.println("==========abstract Constructor==================end");
        }
        public abstract void execute();
    }

    public static class HandlerA extends Handler{
        /**
         * 抽象类构造器主要是给属性初始化的
         *
         * @param successor
         */
        public HandlerA(Handler successor) {
            super(successor);
            System.out.println("==========HandlerA  Constructor==================start");

        }

        public void execute() {
          System.out.println("执行功能A");
          if(successor != null){
              successor.execute();
          }
        }
    }

    public static class HandlerB extends Handler{
        /**
         * 抽象类构造器主要是给属性初始化的
         *
         * @param successor
         */
        public HandlerB(Handler successor) {
            super(successor);
            System.out.println("==========HandlerB  Constructor==================start");
        }

        public void execute() {
            System.out.println("执行功能B");
            if(successor != null){
                successor.execute();
            }
        }
    }

    public static class HandlerC extends Handler{
        /**
         * 抽象类构造器主要是给属性初始化的
         *
         * @param successor
         */
        public HandlerC(Handler successor) {
            super(successor);
            System.out.println("==========HandlerC  Constructor==================start");
        }

        public void execute() {
            System.out.println("执行功能C");
            if(successor != null){
                successor.execute();
            }
        }
    }
}
