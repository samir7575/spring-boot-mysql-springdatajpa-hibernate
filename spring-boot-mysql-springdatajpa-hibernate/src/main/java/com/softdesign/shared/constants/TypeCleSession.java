package com.softdesign.shared.constants;

import com.softdesign.commoninterfaces.HasCode;

public enum TypeCleSession implements HasCode<String>
{
	COOKIE("COOKIE", "cookie"),
	TOKEN_WS("TOKEN_WS", "token_ws");

	private final String code;
	private String description;

	private TypeCleSession(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

}
