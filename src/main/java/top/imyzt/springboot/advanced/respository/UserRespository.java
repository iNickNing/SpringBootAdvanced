package top.imyzt.springboot.advanced.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.imyzt.springboot.advanced.pojo.User;

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
}
