package com.challenge.service.definition;

import com.challenge.domain.User;

public interface UserService {
	
	User findByEmail(String email);

}
