package sample.spring;

import sample.spring.security.Role;
import sample.spring.security.RoleRepository;
import sample.spring.security.User;
import sample.spring.security.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
// 放开下面这行注释即可使用项目配置的真实数据库， 否则使用临时的内存数据库，测试时创建、测试完成时释放
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    User testUser;
    Role testRole;

    @Test
    public void userRepoTest() throws Exception {
        this.entityManager.persist(new User("tst_user", "1234"));
        testUser = this.userRepository.findByUsername("tst_user");
        assertThat(testUser.getUsername()).isEqualTo("tst_user");
        assertThat(testUser.getPassword()).isEqualTo("1234");
    }

    @Test
    public void roleRepoTest() throws Exception {
        this.entityManager.persist(new Role("ROLE_ADMIN"));
        testRole = this.roleRepository.findByName("ROLE_ADMIN");
        assertThat(testRole.getName()).isEqualTo("ROLE_ADMIN");
    }
}
