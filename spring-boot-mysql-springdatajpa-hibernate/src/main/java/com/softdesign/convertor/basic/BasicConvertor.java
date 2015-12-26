package com.softdesign.convertor.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softdesign.domain.GenericPojo;
import com.softdesign.dto.BasicDTO;

/**
 * A GenericConvertor to convert a POJO from/to its associated {@link BasicDTO}. <br>
 * <br/>
 * @author malek
 *
 * @param <POJO>
 * @param <DTO>
 */
public class BasicConvertor<POJO extends GenericPojo<?>, DTO extends BasicDTO>
{

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicConvertor.class);

	public <D extends DTO> D toDTO(POJO source, Class<D> targetClass, String... ignored)
	{
		D target = null;
		try
		{
			if (source == null)
			{
				return target;
			}
			target = targetClass.newInstance();
			PropertyCloner.copyWithoutFields(source, target, ignored);
		} catch (InstantiationException e)
		{
			LOGGER.error(e.getLocalizedMessage(), e);
		} catch (IllegalAccessException e)
		{
			LOGGER.error(e.getLocalizedMessage(), e);
		}
		return target;

	}

	/**
	 * Converts a DTO to a transient POJO of the given target type.
	 * @param source
	 * @param targetClass
	 * @param ignored
	 * @return the converted object
	 */
	public <D extends DTO> POJO toPOJO(D source, Class<POJO> targetClass, String... ignored)
	{
		POJO target = null;
		try
		{
			if (source == null)
			{
				return target;
			}
			target = targetClass.newInstance();
			toExistingPOJO(source, target, ignored);
		} catch (InstantiationException e)
		{
			LOGGER.error(e.getLocalizedMessage(), e);
		} catch (IllegalAccessException e)
		{
			LOGGER.error(e.getLocalizedMessage(), e);
		}
		return target;
	}

	/**
	 * Converts a DTO to an existing POJO instance (which can be either in detached or persisted state).
	 * @param source
	 * @param destination
	 * @param ignored
	 */
	public <D extends DTO> void toExistingPOJO(D source, POJO destination, String... ignored)
	{
		if (source == null)
		{
			return;
		}
		PropertyCloner.copyWithoutFields(source, destination, ignored);
	}

	/**
	 * Converts a POJO to a DTO of the given target type
	 * @param source
	 * @param targetClass
	 * @return the converted object
	 */
	public <D extends DTO> D toDTO(POJO source, Class<D> targetClass)
	{
		return this.toDTO(source, targetClass, (String[]) null);
	}

	/**
	 * Converts a DTO to a transient POJO of the given target type.
	 *
	 * @param source
	 * @param targetClass
	 * @return the converted object
	 */
	public <D extends DTO> POJO toPOJO(D source, Class<POJO> targetClass)
	{
		return this.toPOJO(source, targetClass, (String[]) null);
	}

	/**
	 * Converts a collection of transient POJO to a {@link List} of the provided target type.
	 * @param sources
	 * @param targetType the desired target class (must be a subclass of DTO).
	 * @return the converted list
	 */
	public <D extends DTO> List<D> toDTOList(Collection<POJO> sources, Class<D> targetType)
	{
		List<D> output = new ArrayList<D>();
		if (sources == null)
		{
			return output;
		}
		for (POJO source : sources)
		{
			D d = toDTO(source, targetType);
			output.add(d);
		}
		return output;
	}

	/**
	 * Converts a collection of DTO to a {@link List} of the provided target POJO type.
	 *
	 * @param sources
	 * @param targetClass the desired target class (must be a POJO).
	 * @return
	 */
	public <D extends DTO> List<POJO> toPOJOList(Collection<D> sources, Class<POJO> targetClass)
	{
		List<POJO> output = new ArrayList<POJO>();
		if (sources == null)
		{
			return output;
		}
		for (D d : sources)
		{
			output.add(toPOJO(d, targetClass));
		}
		return output;
	}

	/**
	 * Converts a collection of DTO to a {@link Set} of the provided target POJO type.
	 * @param sources
	 * @param targetClass
	 * @return
	 */
	public <D extends DTO> Set<POJO> toPOJOSet(Collection<D> sources, Class<POJO> targetClass)
	{
		Set<POJO> output = new HashSet<POJO>();
		if (sources == null)
		{
			return output;
		}
		for (D d : sources)
		{
			output.add(toPOJO(d, targetClass));
		}
		return output;
	}
}
