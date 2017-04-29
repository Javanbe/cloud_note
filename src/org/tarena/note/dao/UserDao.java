package org.tarena.note.dao;

import org.tarena.note.entity.User;

public interface UserDao {
	public User findByName(String name) throws Exception;
	public void save(User user);
}
