package com.challenge.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.challenge.dao.UserDao;
import com.challenge.domain.User;

public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findByEmail(String email) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("email", email));
		return (User) criteria.uniqueResult();
	}

}
