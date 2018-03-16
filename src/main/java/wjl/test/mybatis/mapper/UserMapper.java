package wjl.test.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import wjl.test.mybatis.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUser();

    List<User> selectBySelective(User record);

    List<User> selectByTrim(User user);

    @Select("SELECT * FROM t_user WHERE PHONE = #{phone}")
    @ResultMap("UserResultMap")
    List<User> findUserByPhone(@Param("phone") String phone);
}