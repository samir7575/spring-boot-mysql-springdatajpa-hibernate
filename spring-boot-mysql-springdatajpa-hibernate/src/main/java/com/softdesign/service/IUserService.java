package com.softdesign.service;

import com.softdesign.dto.basic.UserDTO;

public interface IUserService
{
	/**
	 * Change old password with the the new password.
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 */
	void changePassword(long userId, String oldPassword, String newPassword);

	/**
	 * Find user by Email
	 * @param email
	 * @return
	 */
	UserDTO findByEmail(String email);

}
