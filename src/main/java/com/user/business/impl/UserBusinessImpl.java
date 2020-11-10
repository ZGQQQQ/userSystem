package com.user.business.impl;

import com.user.business.UserBusiness;
import com.user.domain.entity.User;
import com.user.dto.request.CreateUserRequestDTO;
import com.user.dto.request.ModifyUserRequestDTO;
import com.user.dto.response.UserInfoResponseDTO;
import com.user.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


import javax.annotation.Resource;


@Component
public class UserBusinessImpl implements UserBusiness {

	@Resource
	private UserService userService;

	@Override
	public Long create(CreateUserRequestDTO createUserRequestDTO) {
		User user = new User();
		user.setAge(createUserRequestDTO.getAge());
		user.setName(createUserRequestDTO.getName());
		user.setSchool(createUserRequestDTO.getSchool());
		user.setSex(createUserRequestDTO.getSex());

		return userService.create(user);
	}

	@Override
	public void update(ModifyUserRequestDTO modifyUserRequestDTO) {
		User user = new User();
		user.setId(modifyUserRequestDTO.getId());
		user.setAge(modifyUserRequestDTO.getAge());
		user.setName(modifyUserRequestDTO.getName());
		user.setSex(modifyUserRequestDTO.getSex());
		user.setSchool(modifyUserRequestDTO.getSchool());
		userService.update(user);
	}

	@Override
	public void deleted(Long id) {
		userService.deleted(id);
	}

	@Override
	public UserInfoResponseDTO getById(Long id) {
			User user = userService.getById(id);
			if(ObjectUtils.isEmpty(user)){
				throw new RuntimeException("用户不存在");
			}
			UserInfoResponseDTO userInfoResponseDTO = new UserInfoResponseDTO();
			userInfoResponseDTO.setId(user.getId());
			userInfoResponseDTO.setAge(user.getAge());
			userInfoResponseDTO.setName(user.getName());
			userInfoResponseDTO.setSchool(user.getSchool());
			userInfoResponseDTO.setSex(user.getSex());
			return userInfoResponseDTO;
	}


}
