package wjl.test.mybatis.service;

import wjl.test.mybatis.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    int addUserNew(User user);

    int deleteById(Integer id);

    List<User> findByUser(User user);

    List<User> selectByTrim(User user);

    List<User> findUserByPhone(String phone);

     void test() ;

}
