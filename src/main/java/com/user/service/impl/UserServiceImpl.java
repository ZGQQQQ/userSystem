package com.user.service.impl;

import com.user.domain.entity.User;
import com.user.domain.mapper.UserMapper;
import com.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public Long create(User createUser) {
		return userMapper.create(createUser);
	}

	@Override
	public void update(User modifyUser) {
		userMapper.update(modifyUser);
	}

	@Override
	public void deleted(Long id) {
		userMapper.deleted(id);
	}

	@Override
	public User getById(Long id) {
		return userMapper.getById(id);
	}
}
