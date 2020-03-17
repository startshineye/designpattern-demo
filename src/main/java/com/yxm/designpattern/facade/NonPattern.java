package com.yxm.designpattern.facade;

/**
 * @author yexinming
 * @date 2020/3/18
 * 场景
 *
 * 1、假设我们现在有两个子系统
 * 2、子系统1，有多个内部模块，模块A、模块B和模块C
 * 3、子系统2，现在有一个功能，需要同时依赖3个模块来实现一个功能
 *
 * 总结：系统B(mian方法需要调用ModuleA,ModuleB,ModuleC)
 **/
public class NonPattern {

    public static void main(String[] args) {
        //main代表子系统2,要基于子系统1的3个模块的功能实现一个业务逻辑

        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();

        moduleA.excute();
        moduleB.excute();
        moduleC.excute();
        /**
         * 问题:
         * 问题一：对应子系统1来说，维护成本太高了，就是因为子系统2要care多个模块。如果只是3个模块还凑合，若果是
         * 20个模块呢？那子系统1对子系统2的各个模块的了解就要很多，维护成本很高。
         *
         * 问题二：就这个多个模块组成的一个功能，如果在子系统1的多个地方都使用到了，那么那段代码就会在多个地方
         * 都有重复，复制粘贴的过程，一旦这段业务逻辑修改了，比如还要加入一个模块D的功能，可能就要修改多个地方
         * 的代码，会弄的非常的麻烦
         */
    }


    public static class ModuleA{
        public void excute(){
            System.out.println("子系统1的模块A功能");
        }
    }

    public static class ModuleB{
        public void excute(){
            System.out.println("子系统1的模块B功能");
        }
    }

    public static class ModuleC{
        public void excute(){
            System.out.println("子系统1的模块C功能");
        }
    }
}
