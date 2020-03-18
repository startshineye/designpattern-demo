package com.yxm.designpattern.builder;

/**
 * 优化后的构造器模式
 * @author yexinming
 * @date 2020/3/18
场景
（1）构造一个复杂的对象，很多的属性，有些属性构造的时候需要做一些校验，格式转换
（2）比如：一个对象里面有很多属性:field1,field2,field3,...  我们需要构造这个大对象
 **/
public class OptimizedBuilderPattern {
    public static void main(String[] args) {
        Product product = new ConcreteBuilder()
                .field1("值1")
                .field2("值2")
                .field3("值3")
                .create();
        System.out.println(product);
        //这种模式下去除了Director,每次构建完一个属性之后会返回对应对象
    }

    //=======================builder=====================
    public interface Builder{
        Builder field1(String value);
        Builder field2(String value);
        Builder field3(String value);
        Product create();
    }

    public  static class ConcreteBuilder implements Builder{
        private Product product = new Product();

        public Builder field1(String value) {
            System.out.println("在设置field1之前进行复杂的校验逻辑");
            product.setField1(value);
            return this;
        }

        public Builder field2(String value) {
            System.out.println("在设置field2之前进行复杂的校验逻辑");
            product.setField2(value);
            return this;
        }

        public Builder field3(String value) {
            System.out.println("在设置field3之前进行复杂的校验逻辑");
            product.setField3(value);
            return this;
        }

        public Product create() {
            return product;
        }
    }

    //========================产品========================
    public static class Product{
        private String field1;
        private String field2;
        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "field1='" + field1 + '\'' +
                    ", field2='" + field2 + '\'' +
                    ", field3='" + field3 + '\'' +
                    '}';
        }
    }


}
