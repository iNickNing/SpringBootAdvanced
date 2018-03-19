package top.imyzt.springboot.app.service;

public interface UserService {

    /**
     * 同时插入两个用户.测试事务
     */
    void addTwoUser();

    /**
     * 获取用户年龄
     * @param id
     */
    Integer getAge(Integer id) throws Exception;

}
