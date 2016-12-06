package mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserDAO {

	String MQL_GET_ALL_USERS  = "select * from userdata where username=#{username} and password=#{password};";

	@Select(MQL_GET_ALL_USERS)
	public User selectUser(@Param("username") String userName, @Param("password")String password);

	
}