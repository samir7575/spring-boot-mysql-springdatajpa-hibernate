package com.softdesign.dto.basic;

import com.softdesign.dto.BasicDTO;

public class UserDTO implements BasicDTO
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2793999813046979437L;

	private Long id;
	private String prenom;
	private String nom;
	private String email;
	private String login;
	private String numeroTelFixe;
	private String numeroTelMobile;

	public UserDTO()
	{

	}

	public UserDTO(Long id, String prenom, String email, String login)
	{
		super();
		this.id = id;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String name)
	{
		this.prenom = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getNumeroTelFixe()
	{
		return numeroTelFixe;
	}

	public void setNumeroTelFixe(String numeroTelFixe)
	{
		this.numeroTelFixe = numeroTelFixe;
	}

	public String getNumeroTelMobile()
	{
		return numeroTelMobile;
	}

	public void setNumeroTelMobile(String numeroTelMobile)
	{
		this.numeroTelMobile = numeroTelMobile;
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
		UserDTO other = (UserDTO) obj;
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
		builder.append("UserDTO [");
		if (id != null)
		{
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (prenom != null)
		{
			builder.append("prenom=");
			builder.append(prenom);
			builder.append(", ");
		}
		if (nom != null)
		{
			builder.append("nom=");
			builder.append(nom);
			builder.append(", ");
		}
		if (email != null)
		{
			builder.append("email=");
			builder.append(email);
			builder.append(", ");
		}
		if (login != null)
		{
			builder.append("login=");
			builder.append(login);
			builder.append(", ");
		}
		if (numeroTelFixe != null)
		{
			builder.append("numeroTelFixe=");
			builder.append(numeroTelFixe);
			builder.append(", ");
		}
		if (numeroTelMobile != null)
		{
			builder.append("numeroTelMobile=");
			builder.append(numeroTelMobile);
		}
		builder.append("]");
		return builder.toString();
	}

}
