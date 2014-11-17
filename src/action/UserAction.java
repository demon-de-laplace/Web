package action;

import model.User;
import model.UserDao;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserDao userDao=new UserDao();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String save() {
		boolean unique = userDao.isUnique(user.getUsername());
		if (unique) {
			userDao.save(user);
			return "Login";//���ص�¼����
		} else {
			//throw new AppEx("���û�������");
			return "Error";
		}
	}
	
	public String login() {
		User loginUser = userDao.findUser(user.getUsername(), user.getPassword());
		if (loginUser != null) {
			return "Login";
		} else {
			return "Error";
		}
	}
}
