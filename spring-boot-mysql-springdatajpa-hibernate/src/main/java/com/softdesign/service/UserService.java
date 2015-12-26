package com.softdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesign.convertor.basic.UserConvertor;
import com.softdesign.dao.UserDAO;
import com.softdesign.domain.User;
import com.softdesign.dto.basic.UserDTO;

/**
 * 
 * @author malek
 *
 */
@Service("userService")
public class UserService implements IUserService
{

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserConvertor userConvertor;

	@Override
	public void changePassword(long userId, String oldPassword, String newPassword)
	{
		// TODO
	}

	@Override
	public UserDTO findByEmail(final String email)
	{
		User user = userDAO.findByEmail(email);
		if (user != null && user.getId() > 0)
		{
			return userConvertor.toDTO(user, UserDTO.class);
		}
		return null;
	}

}
