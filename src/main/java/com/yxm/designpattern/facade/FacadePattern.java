package com.yxm.designpattern.facade;
/**
 * @author yexinming
 * @date 2020/3/18
 **/
public class FacadePattern {
    public static void main(String[] args) {
        //main-子系统2调用
        SystemFacada facada = new SystemFacada();
        facada.execute();

        /**
         * 好处1：子系统2不需要care太多的模块，只要care一个门面类的接口就可以了
         * 好处2：如果多个地方都要调用这段逻辑，那么如果这个逻辑变了，只需要在门面类一个地方修改就可以了
         */
    }

    //==================子系统1===================
    /**
     *子系统1的门面类
     */
    public static class SystemFacada{
        //子系统1封装了自己的多个模块,ABC,基于自己多个模块的功能，对外统一暴露出去一个功能
        public void execute(){
            ModuleA moduleA = new ModuleA();
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();

            moduleA.execute();
            moduleB.execute();
            moduleC.execute();
            System.out.println("新增的一段逻辑");
        }
    }


    public static class ModuleA{
        public void execute(){
            System.out.println("子系统1的A模块功能");
        }
    }

    public static class ModuleB{
        public void execute(){
            System.out.println("子系统1的B模块功能");
        }
    }
    public static  class ModuleC{
        public void execute(){
            System.out.println("子系统1的C模块功能");
        }
    }
}
