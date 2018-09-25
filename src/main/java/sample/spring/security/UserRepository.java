package sample.spring.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户名查找数据库，判断此名字的用户是否存在
     * @param username
     * @return
     */
    User findByUsername(String username);
}
