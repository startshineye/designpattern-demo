package com.yxm.designpattern.decorator;

/**
 * @author yexinming
 * @date 2020/3/21
 **/
public class SpringAOPDecoratorPattern {
    /**
     * Spring AOP基于动态代理 实现对目标类增强
     */
    public interface UserService{
        void execute();//执行相关业务逻辑
    }

    //@Transactional
    public static class UserServiceImpl implements UserService{

        public void execute() {
            System.out.println("执行业务操作");
        }
    }

    public class UserServiceImplProxy implements UserService{
        private UserService userService;

        public void execute() {
            // 执行操作之前打开事务
            //connection.startTransaction();
            // 执行目标的功能
            userService.execute();
            // 执行完之后提交事务
            //connection.commitTransaction();
        }

        public UserService getUserService() {
            return userService;
        }

        public void setUserService(UserService userService) {
            this.userService = userService;
        }


    }

}
