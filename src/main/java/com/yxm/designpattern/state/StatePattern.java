package com.yxm.designpattern.state;
/**
 * @author yexinming
 * @date 2020/3/20
场景
（1）销售出库单，状态需要从新建、待审批、已审批、已完成，四个状态之间流转，流转到每个状态的时候，都需要执行那个状态对应的一个逻辑
 **/
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context(new NewState());
        context.execute(1);
        context.execute(2);
        context.execute(3);
        /**
         * 状态模式:
         * 如果某个数据有一个状态的概念,你就可以把数据不同的状态封装到不同状态对应的要执行的业务逻辑中
         * 专门创建一个Context,往Context里面传递一些参数,根据传递的参数不同,Context负责控制状态的流转
         * 传什么参数的时候,数据的状态就流转到那个状态下,同时去执行那个状态对应的state里面的业务逻辑
         */

        /**
         * // 适合场景，数据有状态，状态就一定会流转，从状态1变成状态2
         * // 将不同的状态要执行的代码逻辑封装在不同的state类中
         * // 有一个context类，负责根据传入的参数，决定这份数据的状态流转到什么状态
         * // 同时负责执行那个新状态的代码逻辑
         *
         * // 适合的场景太明显了，只要有状态，都按照标准的状态模式来实现，改进
         * // 不同的状态逻辑放不同的state类
         * // 有一个类负责状态之间的流转以及状态逻辑的执行
         *
         * // 对于有状态的场景，按照面向对象的思想来设计，而不是说，在一堆代码里面
         * // if 开始执行那个状态的一堆逻辑，else if，开始执行另外一个状态的一堆逻辑，屎一样的代码
         * // 代码很清晰，可读性很好，可维护性很好
         */
    }
    //=================================执行状态流转类======================
    public static class Context{
       //根据状态使用不同类,执行不同方法
        private State state;

         public Context(State state){
             this.state = state;
         }

        public void execute(int stateType){
            if(stateType == 1) {
                this.state = new ApprovingState();
                this.state.execute();
            } else if(stateType == 2) {
                this.state = new ApprovedState();
                this.state.execute();
            } else if(stateType == 3) {
                this.state = new FinishedState();
                this.state.execute();
            }
        }
    }

    //================================状态实体==============================
    public interface State{
        void execute();
    }

    public static class NewState implements State{
        public void execute() {
            System.out.println("执行销售出库单新建状态的逻辑");
        }
    }

    public static class ApprovingState implements State{
        public void execute() {
            System.out.println("执行销售出库单待审批状态的逻辑");
        }
    }

    public static class ApprovedState implements State{
        public void execute() {
            System.out.println("执行销售出库单已审批状态的逻辑");
        }
    }

    public static class FinishedState implements State{
        public void execute() {
            System.out.println("执行销售出库单已完成状态的逻辑");
        }
    }

}
