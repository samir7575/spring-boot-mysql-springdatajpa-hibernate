package com.softdesign.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Classe user qui définit l'utilisateur de l'application.
 * @author malek
 *
 */
@Entity
@Table(name = "user")
public class User extends GenericPojo<Long>
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3601177938391840892L;

	private long id;
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@NotNull
	private String login;
	@NotNull
	private String password;
	@NotNull
	private String email;
	private String numeroTelFixe;
	private String numeroTelMobile;

	public User()
	{

	}

	public User(long id)
	{
		this.id = id;
	}

	public User(long id, String email, String prenom, String nom)
	{
		super();
		this.id = id;
		this.email = email;
		this.prenom = prenom;
		this.nom = nom;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user", unique = true, nullable = false)
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	@Column(name = "email", length = 50)
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "prenom", length = 100)
	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	@Column(name = "nom", length = 100)
	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	@Column(name = "login", length = 100)
	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	@Column(name = "numero_tel_fixe", length = 15)
	public String getNumeroTelFixe()
	{
		return numeroTelFixe;
	}

	public void setNumeroTelFixe(String numeroTelFixe)
	{
		this.numeroTelFixe = numeroTelFixe;
	}

	@Column(name = "numero_tel_mobile", length = 15)
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
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (login == null)
		{
			if (other.login != null)
				return false;
		}
		else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", ");
		if (nom != null)
		{
			builder.append("nom=");
			builder.append(nom);
			builder.append(", ");
		}
		if (prenom != null)
		{
			builder.append("prenom=");
			builder.append(prenom);
			builder.append(", ");
		}
		if (login != null)
		{
			builder.append("login=");
			builder.append(login);
			builder.append(", ");
		}
		if (email != null)
		{
			builder.append("email=");
			builder.append(email);
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
