package mybatis;

public class Main {

	public static void main(String[] args) {
		UserBO userBO = new UserBO();
		User user = new User("user", "123", "x@y.com");
		User userResult = userBO.selectUser(user.getUserName(), user.getPassword());
		System.out.println(userResult.toString());
	}

}
