package com.user.domain.mapper;

import com.user.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	Long create(User createUser);

	void update(User modifyUser);

	void deleted(Long id);

	User getById(Long id);

}
