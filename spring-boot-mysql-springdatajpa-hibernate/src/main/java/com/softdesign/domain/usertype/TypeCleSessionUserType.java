/**
 * 
 */
package com.softdesign.domain.usertype;

import com.softdesign.domain.usertype.internals.HasStringCodeUserType;
import com.softdesign.shared.constants.TypeCleSession;

/**
 * @author malek
 *
 */
public class TypeCleSessionUserType extends HasStringCodeUserType<TypeCleSession>
{

	protected TypeCleSessionUserType()
	{
		super(TypeCleSession.class);
	}

}
