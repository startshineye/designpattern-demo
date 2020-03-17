package com.yxm.designpattern.singleton;

/**
 * @author yexinming
 * @date 2020/3/16
 **/
public class UnsafeFullSingletonPattern {
    /**
     * 饱汉模式:说明现在很饱,不着急创建对象;等到要使用时候我们创建对象
     */
    public static class Singleton{
        private static Singleton instance;
        private Singleton(){

        }

        public static Singleton getInstance(){
            /**
             * 假设有2个线程过来
             * 线程基础:线程是并发执行的,是CPU里面不同时间片段;先执行一会线程1,然后停止执行线程1；切换过去执行线程2
             * 执行线程2一会儿之后,再停止执行线程2；回来继续执行线程1；
             *
             * 第一个线程：判断发现instance == null,代码就进入到new Singleton()代码块了。
             * 然后cpu切换到线程2,此时,第二个线程代码也执行到了这里，此时instance == null，那么就没什么问题了，继续往下走
             */
            if(instance == null){
                /**
                 * 第一个线程跑到了这儿来，但是此时第一个线程，还没有执行下面的那行代码
                 * 此时，第二个线程代码也执行到了这儿，cpu切换回线程1
                 * 执行线程1的代码，线程1会创建一个实例出来
                 * 但是切换到线程2去执行的时候，线程2,的代码已经执行到这儿来了，此时又会再一次执行下面的代码
                 * 就是会再一次创建一个实例，之前线程1创建的那个实例，就会被垃圾回收，废弃掉了
                 */
                instance = new Singleton();
            }
            return instance;
        }
    }
}
