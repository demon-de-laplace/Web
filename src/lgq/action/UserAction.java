package lgq.action;

import lgq.model.User;
import lgq.model.UserDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserDao userDao=new UserDao();
	private String info;
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String save() {
		boolean unique = userDao.isUnique(user.getUsername());
		if (unique) {
			user.setId(0);
			userDao.save(user);
			return SUCCESS;
		} else {
			return "Error";
		}
	}
	
	public String login() {
		User loginUser = userDao.findUser(user.getUsername(), user.getPassword());
		if (loginUser != null) {
			ActionContext.getContext().getSession().put("user",loginUser);
			info="登陆成功，欢迎您"+loginUser.getUsername()+",";
			return "Okay";
		} else {
			info="抱歉，您输入的用户名或密码错误，请重试，";
			return "Error";
		}
	}
	public String withdraw(){
		ActionContext.getContext().getSession().remove("user");
		info="注销成功，";
		return "withdraw";
	}
}
