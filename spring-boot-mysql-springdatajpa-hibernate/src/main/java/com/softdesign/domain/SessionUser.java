package com.softdesign.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.softdesign.shared.constants.TypeCleSession;

/**
 * Classe session utilisateur Util pour stocker les infos de la session courante du user et ainsi valider la periode d
 * activité du cookie.(mecanisme palliatif à la non gestion des sessions cote tomcat liée au pb de load balancing..)
 * @author malek
 *
 */
@Entity
@Table(name = "session_user")
public class SessionUser extends GenericPojo<Long>
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 399918598943482865L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSessionUser;
	private User user;
	private Date dateConnexion;
	private Date dateUpdate;
	private String cle;
	private int statut;
	private TypeCleSession typeCle;

	@Column(name = "id_session_user", unique = true, nullable = false)
	public Long getIdSessionUser()
	{
		return idSessionUser;
	}

	public void setIdSessionUser(Long idSessionUser)
	{
		this.idSessionUser = idSessionUser;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST }, targetEntity = User.class)
	@JoinColumn(name = "id_user", nullable = false)
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_connexion", nullable = false, length = 0)
	public Date getDateConnexion()
	{
		return dateConnexion;
	}

	public void setDateConnexion(Date dateConnexion)
	{
		this.dateConnexion = dateConnexion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_connexion", nullable = false, length = 0)
	public Date getDateUpdate()
	{
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate)
	{
		this.dateUpdate = dateUpdate;
	}

	@Column(name = "cle", unique = true, nullable = false)
	public String getCle()
	{
		return cle;
	}

	public void setCle(String cle)
	{
		this.cle = cle;
	}

	@Column(name = "statut")
	public int getStatut()
	{
		return statut;
	}

	public void setStatut(int statut)
	{
		this.statut = statut;
	}

	@Column(name = "type_cle")
	@Type(type = "com.softdesign.domain.usertype.TypeCleSessionUserType")
	public TypeCleSession getTypeCle()
	{
		return typeCle;
	}

	public void setTypeCle(TypeCleSession typeCle)
	{
		this.typeCle = typeCle;
	}

}
