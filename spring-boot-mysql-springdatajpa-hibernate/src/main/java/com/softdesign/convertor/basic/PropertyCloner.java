package com.softdesign.convertor.basic;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

/**
 * An utility class that contains various helper methods that uses {@link BeanUtils}.
 * @author malek
 *
 */
@Service("propertyCloner")
public final class PropertyCloner
{
	private static final String[] ignoreSerial = new String[] { "serialVersionUID" };

	/**
	 * @param source
	 * @param target
	 */
	public static void copyWithoutSerial(Object source, Object target)
	{
		if (source != null && target != null)
		{
			BeanUtils.copyProperties(source, target, ignoreSerial);
		}
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @param fieldsToIgnore
	 */
	public static void copyWithoutFields(Object source, Object target, String... fieldsToIgnore)
	{
		if (source != null && target != null)
		{
			BeanUtils.copyProperties(source, target, fieldsToIgnore);
		}
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @param fieldsToCopy
	 */
	public static void copySpecificFields(Object source, Object target, String... fieldsToCopy)
	{
		copySpecificFields(source, target, Arrays.asList(fieldsToCopy));
	}

	/**
	 * 
	 * @see <a href=
	 *      "http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/validation.html#beans-beans"
	 *      >http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/validation.html#beans-
	 *      beans</a>
	 * @param source
	 * @param target
	 * @param fieldsToCopy
	 */
	public static void copySpecificFields(Object source, Object target, Iterable<String> fieldsToCopy)
	{
		final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
		final BeanWrapper wrappedTarget = new BeanWrapperImpl(target);

		for (final String propertyName : fieldsToCopy)
		{
			wrappedTarget.setPropertyValue(propertyName, wrappedSource.getPropertyValue(propertyName));
		}
	}
}
