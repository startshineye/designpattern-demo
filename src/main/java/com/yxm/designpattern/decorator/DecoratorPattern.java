package com.yxm.designpattern.decorator;

import java.io.*;

/**
 * @author yexinming
 * @date 2020/3/21
 **/
public class DecoratorPattern {
    public static void main(String[] args) {
        /**
         * 1.装饰品模式,会定义一个与目标对象同类型的类,并且这个类会持有目标对象,然后调用目标对象时候做一些pre和post
         */
        ConcreteComponent component = new ConcreteComponent();
        Decorator decorator = new Decorator(component);
        decorator.run();

    }


    //====================装饰类====================
    public static class Decorator implements Component{
        private Component component;

        public Decorator(Component component){
            this.component = component;
        }

        public void run() {
            System.out.println("实现某些动态加强功能");
            component.run();
            System.out.println("实现某些动态加强功能");
        }

    }

    //====================实体类操作=====================
   public  interface Component{
        void run();
    }

    public static class ConcreteComponent implements Component{

        public void run() {
            System.out.println("组件操作");
        }
    }




    public static class Stream{
        /**
         * java 的io中常见的装饰器模式:BufferedReader对InputStreamReader进行了装饰
         * 1.BufferedReader和InputStreamReader都实现了Reader接口
         * 2.BufferedReader引用了InputStreamReader里面的引用
         * @return
         * @throws FileNotFoundException
         */
        BufferedReader getStream() throws FileNotFoundException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("")));
            return  bufferedReader;
        }
    }
}
