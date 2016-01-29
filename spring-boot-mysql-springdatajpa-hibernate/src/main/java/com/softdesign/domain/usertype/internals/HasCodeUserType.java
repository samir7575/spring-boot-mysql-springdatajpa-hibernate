package com.softdesign.domain.usertype.internals;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softdesign.commoninterfaces.HasCode;
import com.softdesign.shared.constants.LookupCodedManager;

/**
 * 
 * @author malek
 *
 * @param <C>
 * @param <E>
 */
public abstract class HasCodeUserType<C extends Serializable, E extends HasCode<C>> implements UserType
{

	private static final Logger LOGGER = LoggerFactory.getLogger(HasCodeUserType.class);
	private Class<E> clazz = null;
	private final int sqlType;
	private final int[] sql_types;

	/**
	 *
	 * @param c
	 * @param sqlType
	 */
	protected HasCodeUserType(Class<E> c, int sqlType)
	{
		this.clazz = c;
		this.sql_types = new int[] { sqlType };
		this.sqlType = sqlType;

	}

	@Override
	public int[] sqlTypes()
	{
		return sql_types;
	}

	@Override
	public Class returnedClass()
	{
		return clazz;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException
	{
		if (x == y)
		{
			return true;
		}
		if (null == x || null == y)
		{
			return false;
		}
		return x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException
	{
		return x.hashCode();
	}

	public abstract C extractFromResultSet(ResultSet resultSet, String[] names) throws SQLException;

	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names, SessionImplementor session, Object owner)
		throws HibernateException, SQLException
	{
		LOGGER.trace("Entering nullSafeGet {} ", Arrays.toString(names));
		C name = extractFromResultSet(resultSet, names);
		LOGGER.trace("Value retrieved from the result set : {} ", name);

		E result = null;
		if (!resultSet.wasNull())
		{
			try
			{
				LOGGER.trace("Retrieving the CODED_MANAGER_FIELD_NAME ");
				Field manager = clazz.getField(LookupCodedManager.CODED_MANAGER_FIELD_NAME);
				LOGGER.trace("The code manager = {} ", manager);
				LookupCodedManager<C, E> managerVal = (LookupCodedManager<C, E>) manager.get(null);
				result = managerVal.get(name);

				if (result == null)
				{
					LOGGER.error("No value foud in the code manager for the name {}.", name);
				}
				else
				{
					LOGGER.trace("Result is = {} ", result);
				}

			} catch (IllegalArgumentException e)
			{
				LOGGER.error(e.getLocalizedMessage(), e);
			} catch (IllegalAccessException e)
			{
				LOGGER.error(e.getLocalizedMessage(), e);
			} catch (SecurityException e)
			{
				LOGGER.error(e.getLocalizedMessage(), e);
			} catch (NoSuchFieldException e)
			{
				LOGGER.error(e.getLocalizedMessage(), e);
			}
		}
		return result;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
		throws HibernateException, SQLException
	{
		if (null == value)
		{
			st.setNull(index, sqlType);
		}
		else
		{
			C code = ((E) value).getCode();
			st.setObject(index, code, sqlType);
		}

	}

	@Override
	public Object deepCopy(Object value) throws HibernateException
	{
		return value;
	}

	@Override
	public boolean isMutable()
	{
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException
	{
		// TODO Auto-generated method stub
		return null;
	}
}
