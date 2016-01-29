package com.softdesign.shared.constants;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.softdesign.commoninterfaces.HasCode;

public class LookupCodedManager<CODE, MANAGED extends HasCode<CODE>>
{
	/**
	 * The lookup map
	 */
	private Map<CODE, MANAGED> byIdMap;

	/**
	 * The field name that should be used for any static reference of a LookupCodedManager.
	 */
	public static final String CODED_MANAGER_FIELD_NAME = "CODED_MANAGER";

	public LookupCodedManager(Collection<? extends MANAGED> values)
	{
		this.byIdMap = new HashMap<CODE, MANAGED>(values.size());
		for (MANAGED tl : values)
		{
			byIdMap.put(tl.getCode(), tl);
		}
	}

	public LookupCodedManager(MANAGED[] values)
	{
		this.byIdMap = new HashMap<CODE, MANAGED>(values.length);
		for (MANAGED tl : values)
		{
			byIdMap.put(tl.getCode(), tl);
		}
	}

	/**
	 * @param code the unique code. A code is always explicitly readable by human. != HasID.
	 * @return the value found, null otherwise.
	 */
	public MANAGED get(CODE code)
	{
		return byIdMap.get(code);
	}

	/**
	 * Similar to get, but returns the provided value if the {@link #get(Object)} returns null.
	 * @param code the unique code. A code is always explicitly readable by human. != HasID.
	 * @param defaultValueIfNull the default value returned if nothing was found.
	 * @return the value found, the default value otherwise.
	 */
	public MANAGED getOrElse(CODE code, MANAGED defaultValueIfNull)
	{
		MANAGED t = byIdMap.get(code);
		if (t == null)
		{
			return defaultValueIfNull;
		}
		return t;
	}

}
