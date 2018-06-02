package org.hey.service;

import org.hey.modle.User;

public interface IUserService {
	
	User findUserByPassword(String userName,String password);

}
