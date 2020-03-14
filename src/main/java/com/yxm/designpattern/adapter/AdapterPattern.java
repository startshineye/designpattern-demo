package com.yxm.designpattern.adapter;

/**
 * @author yexinming
 * @date 2020/3/15
 **/
public class AdapterPattern {

    public static void main(String[] args) {
        NewInterface oldInterface = new NewInterfaceAdapter(new OldInterfaceImpl());
        NewInterface newInterface = new NewInterfaceImpl();

        //适配器里面实现的是新接口，但是真实调用是老街口的实现类和方法
        oldInterface.newRun();
        newInterface.newRun();

        // 适配器模式
        // 就是你手上有新老俩接口和一个老接口的实现类
        // 但是现在系统中要面向新接口来开发，老接口的实现类就不能直接用了，不能直接面向老接口来开发
        // 开发一个老接口到新接口的一个适配器
        // 适配器是"实现了新接口的"，但是适配器中持有"老接口实现类实例的引用"
        // 适配器的新接口方法的实现，全部基于"老接口实现类的老方法"来实现即可
        // 对于调用方而言，只要使用适配器来开发即可，就可以通过面向新接口开发，底层使用老接口实现类
    }

    //===============适配器===================

     public static class NewInterfaceAdapter implements NewInterface{
         private OldInterface oldInterface;

         public NewInterfaceAdapter(OldInterface oldInterface){
             this.oldInterface = oldInterface;
         }
         public void newRun() {
            oldInterface.oldRun();
         }
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
    public static class OldInterfaceImpl implements OldInterface {
        public void oldRun() {
            System.out.println("老版本功能逻辑");
        }
    }

    public static class NewInterfaceImpl implements NewInterface {
        public void newRun() {
            System.out.println("新版本功能逻辑");
        }
    }
}
