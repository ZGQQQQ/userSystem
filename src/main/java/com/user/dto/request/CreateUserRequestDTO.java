package com.user.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class CreateUserRequestDTO {

	@NotNull(message = "用户名不能为空")
	private String name;

	@NotNull(message = "用户年龄不能为空")
	private int age;

	@NotNull(message = "用户学校不能为空")
	private String school;

	@NotNull(message = "用户性别不能为空")
	private Integer sex;

}
