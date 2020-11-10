package com.user.service;

import com.user.domain.entity.User;


public interface UserService {

	Long create(User user);

	void update(User user);

	void deleted(Long id);

	User getById(Long id);
}
