package com.user.business.impl;

import com.user.business.UserBusiness;
import com.user.domain.entity.User;
import com.user.dto.request.CreateUserRequestDTO;
import com.user.dto.request.ModifyUserRequestDTO;
import com.user.dto.response.UserInfoResponseDTO;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Component
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	private RedisTemplate<String, Object> template;

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
		UserInfoResponseDTO userInfoResponseDTO = new UserInfoResponseDTO();

		//组装key
		String userId = String.valueOf(id);
		String cacheKey = "ZGQ:" + userId;

		//先查询redis缓存中是否有用户信息
		User userJson = (User)template.opsForValue().get(cacheKey);
		if (!ObjectUtils.isEmpty(userJson)) {
			userInfoResponseDTO.setId(userJson.getId());
			userInfoResponseDTO.setName(userJson.getName());
			userInfoResponseDTO.setAge(userJson.getAge());
			userInfoResponseDTO.setSex(userJson.getSex());
			userInfoResponseDTO.setSchool(userJson.getSchool());
			return userInfoResponseDTO;
		}

		//若redis中无数据，再去查询数据库
		User user = userService.getById(id);
		if (ObjectUtils.isEmpty(user)) {
			throw new RuntimeException("用户不存在");
		}
		userInfoResponseDTO.setId(user.getId());
		userInfoResponseDTO.setAge(user.getAge());
		userInfoResponseDTO.setName(user.getName());
		userInfoResponseDTO.setSchool(user.getSchool());
		userInfoResponseDTO.setSex(user.getSex());
		template.opsForValue().set(cacheKey,user);
		return userInfoResponseDTO;
	}

}
