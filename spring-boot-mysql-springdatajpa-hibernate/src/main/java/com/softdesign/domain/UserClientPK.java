package com.softdesign.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserClientPK implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6509302801438536302L;

	private User user;
	private Client client;

	public UserClientPK()
	{

	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client", nullable = false)
	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserClientPK other = (UserClientPK) obj;
		if (client == null)
		{
			if (other.client != null)
				return false;
		}
		else if (!client.equals(other.client))
			return false;
		if (user == null)
		{
			if (other.user != null)
				return false;
		}
		else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("UserClientPK [");
		if (user != null)
		{
			builder.append("user=");
			builder.append(user);
			builder.append(", ");
		}
		if (client != null)
		{
			builder.append("client=");
			builder.append(client);
		}
		builder.append("]");
		return builder.toString();
	}

}
