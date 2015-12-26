package com.softdesign.dto.basic;

import org.joda.time.LocalDate;

import com.softdesign.dto.CompositeDTO;

/**
 * 
 * @author malek
 *
 */
public class UserClientDTO implements CompositeDTO
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3238820595261998086L;

	private ClientDTO clientDTO;
	private UserDTO userDTO;
	private LocalDate dateExpiration;

	public UserClientDTO()
	{

	}

	public UserClientDTO(ClientDTO clientDTO, UserDTO userDTO, LocalDate dateExpiration)
	{
		super();
		this.clientDTO = clientDTO;
		this.userDTO = userDTO;
		this.dateExpiration = dateExpiration;
	}

	public ClientDTO getClientDTO()
	{
		return clientDTO;
	}

	public void setClientDTO(ClientDTO clientDTO)
	{
		this.clientDTO = clientDTO;
	}

	public UserDTO getUserDTO()
	{
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO)
	{
		this.userDTO = userDTO;
	}

	public LocalDate getDateExpiration()
	{
		return dateExpiration;
	}

	public void setDateExpiration(LocalDate dateExpiration)
	{
		this.dateExpiration = dateExpiration;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("UserClientDTO [");
		if (clientDTO != null)
		{
			builder.append("clientDTO=");
			builder.append(clientDTO);
			builder.append(", ");
		}
		if (userDTO != null)
		{
			builder.append("userDTO=");
			builder.append(userDTO);
			builder.append(", ");
		}
		if (dateExpiration != null)
		{
			builder.append("dateExpiration=");
			builder.append(dateExpiration);
		}
		builder.append("]");
		return builder.toString();
	}

}
