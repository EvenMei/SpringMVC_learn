import com.meiyukai.dao.IUserDao;
import com.meiyukai.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUser {

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Test
    public void testFindUserById(){
        User user = userDao.findUserById(2);
        System.out.println("user  :   "  + user);

    }
}
