package com.yxm.designpattern.memento;

/**
 * @author yexinming
 * @date 2020/3/20
场景:
（1）类，计算出来一份中间数据
（2）这个类，之后需要基于这份中间数据再执行另外两次操作，每次操作都要基于这份中间数据去执行
（3）第一次基于中间数据操作过后，会对中间数据做出修改
（4）要求是第二次再执行操作的时候，需要基于未修改之前的中间数据来执行
 **/
public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();

        //准备好中间数据
        originator.prepare();

        //将中间数据保存到备忘录中
        Memento memento = originator.createMemento();
        // 将备忘录保存到备忘录管理器中去
        Caretaker caretaker = new Caretaker();
        caretaker.saveMemento(memento);

        // 基于中间数据执行了A方法，但是此时中间数据已经改变了
        originator.executeA();
        // 从备忘录管理器中获取备忘录
        memento = caretaker.retrieveMemento();
        // 将备忘录中保存好的中间数据重新设置到原发器中去，就将中间数据恢复成了之前备忘的状态
        originator.setMemento(memento);
        // 接着再次执行方法B
        originator.executeB();

        // 面临的场景
        // 你的系统会生产出来一份中间数据，这份中间数据要么是没法一直在内存里保留，要么是可能会被修改
        // 所以逼得你迫不得已，必须得通过备忘录的方式，将中间数据暂存一份儿
        // 在一堆操作过后，可能之前内存中的中间数据都弄丢了，也可能中间数据被人篡改了
        // 接下来，你需要从备忘录中恢复我们的中间数据
        // 基于恢复后的中间数据，再次执行后面的操作
    }


    //========================实体类============
    public interface Memento{

    }

    public static class Originator{
        private String state;

        public void prepare(){
            this.state = "中间数据";
        }

        public void executeA(){
            System.out.println("基于中间数据【" + state +"】执行了A方法的逻辑");
            // 将state所代表的中间数据做出了修改
            state += "，A方法的结果数据";
        }

        public void executeB(){
            System.out.println("基于中间数据【" + state +"】执行了B方法的逻辑");
            state += "，B方法的结果数据";
        }

        public Memento createMemento() {
            return new MementoImpl(state);
        }

        public void setMemento(Memento memento) {
            MementoImpl mementoImpl = (MementoImpl)memento;
            this.state = mementoImpl.getState();
        }


        private static class MementoImpl implements Memento {

            private String state;

            public MementoImpl(String state) {
                this.state = state;
            }

            public String getState() {
                return state;
            }

        }
    }

    public static class Caretaker {

        private Memento memento;

        public void saveMemento(Memento memento) {
            this.memento = memento;
        }

        public Memento retrieveMemento() {
            return this.memento;
        }

    }
}
