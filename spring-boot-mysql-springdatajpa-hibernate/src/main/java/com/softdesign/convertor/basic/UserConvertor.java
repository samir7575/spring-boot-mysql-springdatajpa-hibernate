package com.softdesign.convertor.basic;

import org.springframework.stereotype.Component;

import com.softdesign.domain.User;
import com.softdesign.dto.basic.UserDTO;

@Component("userConvertor")
public class UserConvertor extends BasicConvertor<User, UserDTO>
{
	@Override
	public <D extends UserDTO> D toDTO(User source, Class<D> targetClass, String... ignored)
	{
		return super.toDTO(source, targetClass, source.getPassword());
	}

}
