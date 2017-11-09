package com.springboot.dao;

import java.util.List;

import com.springboot.model.User;
/**
 * 
 * @author Daner (Kas-2017)
 */
public interface UserDao {

	User findByName(String name);
	
	List<User> findAll();

}