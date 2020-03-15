package com.yxm.designpattern.factory;

/**
 * @author yexinming
 * @date 2020/3/15
 场景:
 我们创建对象
 *
 * */

public class NonPattern {
    public static void main(String[] args) {
        //1.我们使用传统方式创建产品
        Produnct produnct = new Produnct("猕猴桃");
        System.out.println(produnct);

        //2.但是如果我们修改了产品类属性和构造器,那么通过new创建对象将会改变,如果系统通过new创建的对象很多,那么我们每一处都得改动

        // 有什么问题
        // 如果你直接面向一个类来编程，new来创建类的实例的话，你就是后面会死的很惨
        // 我们如果对Product，要更换一个类，换一个类的实现
        // 此时就必须在创建这个类实例的地方，都要修改一下这个代码
        // 如果你有100个地方，都创建了Product这个类的实例
        // 你需要在100个地方都去修改这个new Product()的这段代码
        // 代码可维护性和可扩展性之差，惨不忍睹，垃圾代码
    }

    public static class Produnct{
        private String name;

        public Produnct(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Produnct{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
