package com.yxm.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author yexinming
 * @date 2020/3/19
场景
（1）比如我们有一个目标对象，
一旦这个目标对象的状态改变了，
然后的话就去通知相关的对象，
我的状态改变了，数据也变化了。

 我们基于jdk自带的组件实现观察者模式:Observable

 **/
public class ObserverPattern {
    public static void main(String[] args) {
        /**
         *
         */

        //给主体绑定一个观察者: 告诉主体:哪个观察者在观察你;
        //往对象里面添加观察者需要继承jdk自带的加锁的Observable类

        //1.创建主体对象:默认状态为0
        Subject subject = new Subject(0);

        //2.注册/绑定一个观察者
        Observer observer = new ConcretObserver();
        subject.addObserver(observer);

        //3.主体变化,监听变化
        subject.setState(1);
    }

    public static class Subject extends Observable{
        private Integer state;

        public Subject(Integer state){
            this.state = state;
        }

        public Integer getState(){
            return this.state;
        }

        public void setState(Integer state){
            //在这里状态发生改变
            this.state=state;
            //通知关联的一些观察者，说我的状态变化了
            this.setChanged();
            //this.notifyObservers(state);
            this.notifyObservers(this);
        }
    }

    public static class ConcretObserver implements Observer{

        public void update(Observable observable, Object arg) {
            //Integer state = (Integer) arg;
             Subject subject = (Subject) arg;
            Integer state = subject.getState();
            System.out.println("观察者:目标对象的状态变化成：" + state);
        }
    }

}
