package com.user.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ModifyUserRequestDTO {

	@NotNull(message = "用户id不能为空")
	private Long id;

	private String name;

	private int age;

	private String school;

	private Integer sex;

}
