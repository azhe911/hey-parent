package org.hey.service.impl;

import java.util.List;

import org.hey.modle.User;
import org.hey.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IUserDao;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	public User findUserByPassword(String userName, String password) {
		List<User> user = userDao.findUserByPassword(userName, password);	
		if (user != null && user.size() >0) {
			return user.get(0);
		} 
		return null;
	}
}
