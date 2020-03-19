package com.yxm.designpattern.strategy;

/**
 * @author yexinming
 * @date 2020/3/20
 **/
public class StrategyPattern {

    public static void main(String[] args) {
        /**
         * 策略模式就是:
         * 1.自定义一个策略接口,里面定义一个方法
         * 2.根据策略接口 可以定义多个策略
         * 3.把各个if-elase逻辑划分到各个策略中(每个策略封装了自己对应的逻辑)---满足什么条件返回什么策略
         * 4.把if-else 这种选择扔到一个工厂里面去
         * 5.策略的真正执行我们将其封装到:Context里面去
         */


        /**
         *要点:
         * 1.要点1：必须将if else的代码，封装到不同的策略类中
         * 2.要点2：将选择哪种策略的逻辑给放到一个工厂类中去，选择策略的代码务必很简洁
         * 3.要点3：context可有可无，具体是看你的策略执行这块如果就一行代码调用，不需要context；
         * 如果context中的策略执行逻辑较为复杂一点，context来封装策略类的执行逻辑
         */

        /**
         * 策略模式与命令模式不同:
         * 策略模式跟命令模式的区别？
         * 看起来一样的，但是用处不一样。命令是可以发送出去，然后可以经过一些队列的流转，
         * 比如先把命令发送到MQ，接着再处理。策略是说选择了一组策略，立即就要执行的，
         * 不会经过其他别的什么处理。而且策略逻辑基本就是用在复杂的if else代码中的
         */
        int distanceType = 1;
        DistanceChoiceStrategy distanceChoiceStrategy = DistanceChoiceStrategyFactory.getDistanceChoiceStrategy(distanceType);

        Context context = new Context();
        context.setStrategy(distanceChoiceStrategy);
        context.choice();
    }
    //================================具体方法调用执行类====================================
        public static class Context{
            private DistanceChoiceStrategy strategy;

            public DistanceChoiceStrategy getStrategy() {
                return strategy;
            }

            public void setStrategy(DistanceChoiceStrategy strategy) {
                this.strategy = strategy;
            }

            void choice(){
                strategy.choice();
            }
    }

    //================================ 生产各个策略类工厂=====================================
    public static class DistanceChoiceStrategyFactory{
         public static DistanceChoiceStrategy getDistanceChoiceStrategy(int distanceType){
             if (distanceType==1){
                 return new DistanceChoiceStrategyA();
             }else if(distanceType == 2){
                 return new DistanceChoiceStrategyA();
             }else if(distanceType == 3){
                 return new DistanceChoiceStrategyA();
             }else {
                 return new DistanceChoiceStrategyDefault();
             }
         }
    }


    //=================================封装if-else的各个策略=====================================
    public interface DistanceChoiceStrategy{
        void choice();
    }

    public static class DistanceChoiceStrategyA implements DistanceChoiceStrategy{
        public void choice() {
            System.out.println("远行车类型A");
        }
    }

    public static class DistanceChoiceStrategyB implements DistanceChoiceStrategy{
        public void choice() {
            System.out.println("远行车类型B");
        }
    }

    public static class DistanceChoiceStrategyC implements DistanceChoiceStrategy{
        public void choice() {
            System.out.println("远行车类型C");
        }
    }

    public static class DistanceChoiceStrategyDefault implements DistanceChoiceStrategy{
        public void choice() {
            System.out.println("远行车默认类型");
        }
    }
}
