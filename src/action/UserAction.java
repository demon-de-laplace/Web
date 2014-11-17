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
			return "Login";//返回登录界面
		} else {
			//throw new AppEx("此用户不可用");
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
