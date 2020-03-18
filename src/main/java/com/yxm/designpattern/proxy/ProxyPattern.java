package com.yxm.designpattern.proxy;

/**
 * @author yexinming
 * @date 2020/3/19
 **/
public class ProxyPattern {
    public static void main(String[] args) {
        /**
         * 代理模式一般有3个类:
         * 主体、主体实现类、代理类;代理类和实体主体实现相同接口 类似于现实中 我们找人做代理需要找到合适的人
         * 我们需要调用实体类的request请求  但是我们自己不去调用,而是使用实体类的代理类去调用
         */
        Subject subject = new ConcreteSubject();
        Proxy proxy = new Proxy(subject);
        proxy.request();
    }

    public interface Subject{
        void request();
    }

    public static class ConcreteSubject implements Subject{
        public void request() {
          System.out.println("主体执行请求");
        }
    }

    public static class Proxy implements Subject{
        /**
         * 代理类代理主体,肯定需要拿到主体
         * 我们可以对代理类代理主体之前做一些额外事情
         */
        private Subject subject;

        public Proxy(Subject subject){
            this.subject = subject;
        }

        public void request() {
            System.out.println("执行额外的条件判断，判断是否要调用subject的request()方法");
            boolean result = true;
            if(result){
              subject.request();
            }
        }
    }
}
