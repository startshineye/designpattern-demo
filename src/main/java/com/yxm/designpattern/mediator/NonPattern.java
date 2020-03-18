package com.yxm.designpattern.mediator;

/**
 * @author yexinming
 * @date 2020/3/19
 *场景
 * （1）三个模块
 * （2）模块1调用模块2和模块3；模块2要调用模块1和模块3；模块3要调用模块1和模块2
 **/
public class NonPattern {
    public static void main(String[] args) {
        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();

        /**
         * 模块之间有非常复杂的互相之间的跟蜘蛛网一样的调用
         * 问题，每个模块都要去care很多其他的模块，互相之间耦合很严重
         * 后面在修改代码的时候，代码不好改，模块B一旦修改了自己的代码，可能会影响模块A和模块C
         */
    }

    public static class ModuleA{
        public void execute(){
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();

            moduleB.execute("模块A");
            moduleC.execute("模块A");
        }
        public void execute(String invoker){
            System.out.println(invoker + "在调用模块A的功能");
        }
    }

    public static class ModuleB{
        public void execute(){
            ModuleC moduleC = new ModuleC();
            ModuleA moduleA = new ModuleA();

            moduleC.execute("模块B");
            moduleA.execute("模块B");
        }
        public void execute(String invoker){
            System.out.println(invoker + "在调用模块A的功能");
        }
    }

    public static class ModuleC{
        public void execute(){
            ModuleB moduleB = new ModuleB();
            ModuleA moduleA = new ModuleA();

            moduleA.execute("模块C");
            moduleB.execute("模块C");
        }
        public void execute(String invoker){
            System.out.println(invoker + "在调用模块A的功能");
        }
    }
}
