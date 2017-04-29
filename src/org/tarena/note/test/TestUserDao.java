package org.tarena.note.test;

import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.User;

public class TestUserDao extends TestBase {
	public static void main(String[] args) throws Exception {
		UserDao userDao = getContext().getBean("userDao",UserDao.class);
		User user = userDao.findByName("demo1");
		if(user == null){
			System.out.println("用户名不存在");
		}else{
			System.out.println(user.getCn_user_password());
		}
		
	}
}
