package com.softdesign.tools;

import org.mindrot.jbcrypt.BCrypt;

public class BlowfishAlgoBCRYPT
{

	public static final String bcCrypt(String password)
	{
		// Hashage d'un mot de passe
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

		// Il est possible d'augmenter la complexité (et donc le temps
		// de traitement) en passant le "workfactor" en paramètre
		// ici : 12 La valeur par défaut est 10
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

		return hashedPassword;
	}
}
