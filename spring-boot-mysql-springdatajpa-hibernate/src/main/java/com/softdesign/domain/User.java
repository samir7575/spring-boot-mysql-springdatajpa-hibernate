package com.softdesign.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3601177938391840892L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String email;
	@NotNull
	private String name;

	@NotNull
	private String password;

	public User()
	{
	}

	public User(long id)
	{
		this.id = id;
	}

	public User(String email, String name, String password)
	{
		this.email = email;
		this.name = name;
		this.password = password;
	}

	@Column(name = "id_user")
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", ");
		if (email != null)
		{
			builder.append("email=");
			builder.append(email);
			builder.append(", ");
		}
		if (name != null)
		{
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (password != null)
		{
			builder.append("password=");
			builder.append(password);
		}
		builder.append("]");
		return builder.toString();
	}

}
