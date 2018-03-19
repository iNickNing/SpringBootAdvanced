package top.imyzt.springboot.advanced.service;

public interface UserService {

    /**
     * 同时插入两个用户.测试事务
     */
    void addTwoUser();

    /**
     * 获取用户年龄
     * @param id
     */
    void getAge(Integer id) throws Exception;
}
