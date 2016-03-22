package com.challenge.service.impl;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.challenge.dao.UserDao;
import com.challenge.domain.User;
import com.challenge.service.definition.UserService;

@Transactional
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDao userDao;

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
