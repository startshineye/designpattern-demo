package com.yxm.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yexinming
 * @date 2020/3/20
场景
（1）我们现在要缓存一些数据，比如说权限，根据权限的ID作为key，权限数据自己本身是value
（2）但是我们不需要使用太复杂的ehcache框架之类的去使用，特别特别的简单的
（3）我们就想基于自己的Map去实现一套东西
 **/
public class FlyweightPattern {
    public static void main(String[] args) {
        /**
         * 1.创建一个享元对象（面向接口编程）
         * 2.创建一个工厂类(可以缓存享元对象)
         */
        Flyweight flyweight1 = FlyweightFactory.get("张三");
        flyweight1.execute();

        Flyweight flyweight2 = FlyweightFactory.get("张三");
        flyweight2.execute();

        System.out.println(flyweight1 == flyweight2);
        // 享元
        // 享受，元数据
        // 同一个数据，我就认为是一个元数据，整个系统里这个数据就一份，缓存起来
        // 整个系统对这个数据，全部享受他一个对象实例即可

        // 直接既有内存来缓存一块数据，用享元模式
    }


    //=========================创建实体工厂============================
    public static class FlyweightFactory{
        private static Map<String,Flyweight> maps = new HashMap<String,Flyweight>();

        public static Flyweight get(String name){
            Flyweight flyweight = maps.get(name);
            if(flyweight == null){
                flyweight = new ConcreteFlyweight(name);
                maps.put(name,flyweight);
            }
            return flyweight;
        }
    }


    //==========================创建实体类===============================
    public interface Flyweight{
        void execute();
    }

    public static class ConcreteFlyweight implements Flyweight{
        private String name;
        public ConcreteFlyweight(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void execute() {
            System.out.println(this.name+" 执行功能逻辑");
        }
    }


}
