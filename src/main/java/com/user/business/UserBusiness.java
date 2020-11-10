package com.user.business;

import com.user.dto.request.CreateUserRequestDTO;
import com.user.dto.request.ModifyUserRequestDTO;
import com.user.dto.response.UserInfoResponseDTO;

public interface UserBusiness {

	Long create(CreateUserRequestDTO createUserRequestDTO);

	void update(ModifyUserRequestDTO modifyUserRequestDTO);

	void deleted(Long id);

	UserInfoResponseDTO getById(Long id);

}
