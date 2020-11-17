package com.user.domain.entity;

import lombok.Data;

@Data
public class User {

	private Long id;

	private String name;

	private int age;

	private String school;

	//版本1
	private Integer sex;
}
