package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hey.modle.User;

public interface IUserDao {

	List<User> findUserByPassword(@Param("userName")String userName,@Param("password")String password);
}
