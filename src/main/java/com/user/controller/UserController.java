package com.user.controller;


import com.user.business.UserBusiness;
import com.user.dto.request.CreateUserRequestDTO;
import com.user.dto.request.ModifyUserRequestDTO;
import com.user.dto.response.UserInfoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserBusiness userBusiness;

	@PostMapping("/create")
	public Long create(@Validated @RequestBody CreateUserRequestDTO createUserRequestDTO){
		return userBusiness.create(createUserRequestDTO);
	}

	@PostMapping("/update")
	public void update(@Validated @RequestBody ModifyUserRequestDTO modifyUserRequestDTO){
		userBusiness.update(modifyUserRequestDTO);
	}

	@GetMapping("/deleted/{id}")
	public void update(@PathVariable Long id){
		userBusiness.deleted(id);
	}

	@GetMapping("/get/{id}")
	public UserInfoResponseDTO get(@PathVariable Long id){
		return userBusiness.getById(id);
	}

}
