package com.yxm.designpattern.singleton;
/**
 * @author yexinming
 * @date 2020/3/16
 **/
public class HungrySingletonPattern {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println("第"+i+"次调用");
             HungrySingleton.getInstance();
        }
    }
}
