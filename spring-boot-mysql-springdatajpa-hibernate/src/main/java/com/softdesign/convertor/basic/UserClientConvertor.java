package com.softdesign.convertor.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softdesign.domain.UserClient;
import com.softdesign.dto.basic.ClientDTO;
import com.softdesign.dto.basic.UserClientDTO;
import com.softdesign.dto.basic.UserDTO;

@Component("userClientConvertor")
public class UserClientConvertor
{
	@Autowired
	private ClientConvertor clientConvertor;
	@Autowired
	private UserConvertor userConvertor;

	public UserClientDTO toDTO(UserClient source, boolean withUser)
	{
		UserClientDTO userClientDTO = new UserClientDTO();
		if (withUser)
		{
			userClientDTO.setUserDTO(userConvertor.toDTO(source.getUser(), UserDTO.class));
		}
		userClientDTO.setClientDTO(clientConvertor.toDTO(source.getClient(), ClientDTO.class));
		return userClientDTO;
	}

	public List<UserClientDTO> toDTOList(Collection<UserClient> pbcsList)
	{
		List<UserClientDTO> outlist = new ArrayList<UserClientDTO>();
		for (UserClient pbcs : pbcsList)
		{
			outlist.add(toDTO(pbcs, true));
		}
		return outlist;
	}

}
