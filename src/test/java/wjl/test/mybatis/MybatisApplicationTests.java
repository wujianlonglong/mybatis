package wjl.test.mybatis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import wjl.test.mybatis.mapper.UserMapper;
import wjl.test.mybatis.model.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Test
    @Transactional
    @Rollback(false)
    public void test() {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        user.setPhone("18600000000");
        int j=userMapper.insertSelective(user);
        int i=1/0;
      //  List<User> u = userMapper.findUserByPhone("12345678990");
        //Assert.assertEquals("winterchen", u.get(0).getUserName());
    }

}
