package com.softdesign.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.softdesign.domain.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Long>{
	public User findByEmail(String email);
}
