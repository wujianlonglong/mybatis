package wjl.test.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wjl.test.mybatis.mapper.UserMapper;
import wjl.test.mybatis.model.User;
import wjl.test.mybatis.service.UserService;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(User user) {

        return userMapper.insertSelective(user);
    }


    @Override
    public int addUserNew(User user) {

        return userMapper.insert(user);
    }

    @Override
    public int deleteById(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }


    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }

    @Override
    public List<User> findByUser(User user){
        return userMapper.selectBySelective(user);
    }

    @Override
    public List<User> selectByTrim(User user){
        return userMapper.selectByTrim(user);
    }


    @Override
    public  List<User> findUserByPhone(String phone){
        return userMapper.findUserByPhone(phone);
    }

    @Override
    @Transactional
    public void test() {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        user.setPhone("18600000000");
        int j=userMapper.insertSelective(user);
       // int i=1/0;
        List<User> u = userMapper.findUserByPhone("12345678990");
        System.out.println(u.toString());
    }
}