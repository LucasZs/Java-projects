package mybatis;

import org.apache.ibatis.session.SqlSession;


public class UserBO { 

	public User selectUser(String userName, String password){
		SqlSession session = ConnectionFactory.getSession().openSession();
			UserDAO dao =session.getMapper(UserDAO.class);
			User user = dao.selectUser(userName, password);
			session.close();
		return user;
	}
	
}
