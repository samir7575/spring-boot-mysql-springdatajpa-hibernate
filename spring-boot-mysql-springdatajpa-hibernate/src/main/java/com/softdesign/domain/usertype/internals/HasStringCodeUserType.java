package com.softdesign.domain.usertype.internals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.softdesign.commoninterfaces.HasCode;

/**
 * 
 * @author malek
 *
 */
public class HasStringCodeUserType<E extends HasCode<String>> extends HasCodeUserType<String, E>
{

	protected HasStringCodeUserType(Class<E> c)
	{
		super(c, Types.VARCHAR);
	}

	@Override
	public String extractFromResultSet(ResultSet resultSet, String[] names) throws SQLException
	{
		return resultSet.getString(names[0]);
	}

}
