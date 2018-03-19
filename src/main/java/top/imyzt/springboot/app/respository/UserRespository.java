package top.imyzt.springboot.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.imyzt.springboot.app.pojo.User;

import java.util.List;

/**
 * 用户操作
 */
public interface UserRespository extends JpaRepository<User, Integer>{

    /**
     * 通过年龄查询
     * @param age 年龄
     * @return
     */
    List<User> findByAge(Integer age);

    /**
     * 通过姓名查询
     * @param name 姓名
     * @return
     */
    List<User> findByName(String name);
}
