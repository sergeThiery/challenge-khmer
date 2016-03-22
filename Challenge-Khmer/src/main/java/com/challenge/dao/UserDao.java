package com.challenge.dao;

import com.challenge.domain.User;

public interface UserDao {
	
	User findByEmail(String email);

}
