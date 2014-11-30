package lgq.model;

import lgq.action.HibernateSessionFactory;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDao {
	private Session session = null;
	
	public UserDao() {
		//session = HibernateSessionFactory.getSession();
	}
	
	public void save(User user) {
		try {
		session = HibernateSessionFactory.getSession();	
		session.beginTransaction();
		user.setId(3);
		session.save(user);
		session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	public void delete(User user) {
		try {
			session = HibernateSessionFactory.getSession();	
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	public User findUserById(int id) {
		User user = null;
		try {
			session = HibernateSessionFactory.getSession();	
			session.beginTransaction();
			user = (User) session.get(User.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return user;
	}
	
	public boolean isUnique(String username) {
		boolean exist = false;
		try{
			session = HibernateSessionFactory.getSession();	
			session.beginTransaction();
			String hql ="from User u where u.username=\'"+username+"\'";
			Query query = session.createQuery(hql);
			Object user = query.uniqueResult();
			if(user == null) {
				exist = true;
			}
			session.getTransaction().commit();
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return exist;
	}
	
	public User findUser(String username,String password) {
		Session session = null;
		User user = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql = "from User u where u.username= '"+username+"' and u.password= '"+password+"'";
			Query query = session.createQuery(hql);
			user = (User) query.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return user;
	}
	
}
