package com.softdesign.domain;

import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * Classe client de l'application.
 * @author malek
 *
 */
@Entity
@Table(name = "client")
public class Client extends GenericPojo<Long>
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7075122918229295002L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nom;
	@NotNull
	private String codeExploitant;
	@NotNull
	private Locale langue;
	@NotNull
	private String fuseauHoraire;
	@NotNull
	private Date dateCreation;

	public Client()
	{

	}

	@Column(name = "id_client")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "nom", length = 150)
	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	@Column(name = "codeExploitant", length = 3)
	public String getCodeExploitant()
	{
		return codeExploitant;
	}

	public void setCodeExploitant(String codeExploitant)
	{
		this.codeExploitant = codeExploitant;
	}

	@Column(name = "langue")
	@Type(type = "org.hibernate.type.LocaleType")
	public Locale getLangue()
	{
		return langue;
	}

	public void setLangue(Locale langue)
	{
		this.langue = langue;
	}

	@Column(name = "fuseau_horaire")
	public String getFuseauHoraire()
	{
		return fuseauHoraire;
	}

	public void setFuseauHoraire(String fuseauHoraire)
	{
		this.fuseauHoraire = fuseauHoraire;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_creation")
	public Date getDateCreation()
	{
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation)
	{
		this.dateCreation = dateCreation;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeExploitant == null) ? 0 : codeExploitant.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Client other = (Client) obj;
		if (codeExploitant == null)
		{
			if (other.codeExploitant != null)
				return false;
		}
		else if (!codeExploitant.equals(other.codeExploitant))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (nom == null)
		{
			if (other.nom != null)
				return false;
		}
		else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Client [");
		if (id != null)
		{
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (nom != null)
		{
			builder.append("nom=");
			builder.append(nom);
			builder.append(", ");
		}
		if (codeExploitant != null)
		{
			builder.append("codeExploitant=");
			builder.append(codeExploitant);
			builder.append(", ");
		}
		if (langue != null)
		{
			builder.append("langue=");
			builder.append(langue);
			builder.append(", ");
		}
		if (fuseauHoraire != null)
		{
			builder.append("fuseauHoraire=");
			builder.append(fuseauHoraire);
			builder.append(", ");
		}
		if (dateCreation != null)
		{
			builder.append("dateCreation=");
			builder.append(dateCreation);
		}
		builder.append("]");
		return builder.toString();
	}

}
