package top.imyzt.springboot.advanced.service;

public interface UserService {

    /**
     * 同时插入两个用户.测试事务
     */
    void addTwoUser();
}
