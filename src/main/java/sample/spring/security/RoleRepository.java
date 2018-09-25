package sample.spring.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * 根据角色名称查找角色对象
     * @param name
     * @return
     */
    Role findByName(String name);
}
