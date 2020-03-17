package com.yxm.designpattern.singleton;
/**
 * @author yexinming
 * @date 2020/3/16
 **/
public class HungrySingleton {
    /**
     * 饿汉式单例模式:说明创建对象很着急，很饥饿,所以一开始就创建对象了
     * 分为三步:
     * 第一步：直接就是将这个类的实例在创建出来，赋予static final修饰的变量
     * static：就是一个类的静态变量
     * final：这个变量的引用第一次初始化赋予之后，就再也不能修改引用了
     *
     * 第二步：将构造函数搞成private私有的
     *此时除了这个类自己本身，其他任何人都不能创建它的这个实例对象
     *
     * 第三步：给一个static静态方法，返回自己唯一的内部创建的一个实例
     */

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        System.out.println(instance);
       return instance;
    }
}
