package top.imyzt.springboot.advanced.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.imyzt.springboot.advanced.pojo.User;

/**
 * 用户操作
 */
public interface UserRespository extends JpaRepository<User, Integer>{
}
