package com.softdesign.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.joda.time.LocalDate;

@Entity
@Table(name = "user_client")
public class UserClient extends GenericPojo<Long>
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6413164933716637652L;

	@EmbeddedId
	private UserClientPK id;
	@NotNull
	private LocalDate dateExpiration;

	public UserClientPK getId()
	{
		return id;
	}

	public void setId(UserClientPK id)
	{
		this.id = id;
	}

	@Transient
	public Client getClient()
	{
		return id.getClient();
	}

	@Transient
	public User getUser()
	{
		return id.getUser();
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_expiration", nullable = false)
	public LocalDate getDateExpiration()
	{
		return dateExpiration;
	}

	public void setDateExpiration(LocalDate dateExpiration)
	{
		this.dateExpiration = dateExpiration;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserClient other = (UserClient) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("UtilisateurClient [");
		if (id != null)
		{
			builder.append("id=");
			builder.append(id);
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
