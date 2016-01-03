package com.softdesign.test.controller;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.softdesign.controller.SoftdesignPathConstants;

/**
 * To test Spring Security aware REST API, a servletPath is required since Spring Security intercepts URLs in its filter
 * chain. Hence, this class aims to be a drop in replacement for {@link MockMvcRequestBuilders} where the generated
 * {@link MockHttpServletRequestBuilder} has a a servletPath equals to "/".
 *
 */
public final class RestApiMockMvcRequestBuilders
{

	/**
	 * Create a {@link MockHttpServletRequestBuilder} for a GET request.
	 * @param urlTemplate a URL template; the resulting URL will be encoded
	 * @param urlVariables zero or more URL variables
	 */
	public static MockHttpServletRequestBuilder get(String urlTemplate, Object... urlVariables)
	{
		return MockMvcRequestBuilders.get(urlTemplate, urlVariables).servletPath(SoftdesignPathConstants.REST_API);
	}

	/**
	 * Create a {@link MockHttpServletRequestBuilder} for a POST request.
	 * @param urlTemplate a URL template; the resulting URL will be encoded
	 * @param urlVariables zero or more URL variables
	 */
	public static MockHttpServletRequestBuilder post(String urlTemplate, Object... urlVariables)
	{
		return MockMvcRequestBuilders.post(urlTemplate, urlVariables).servletPath(SoftdesignPathConstants.REST_API);
	}

	/**
	 * Create a {@link MockHttpServletRequestBuilder} for a PUT request.
	 * @param urlTemplate a URL template; the resulting URL will be encoded
	 * @param urlVariables zero or more URL variables
	 */
	public static MockHttpServletRequestBuilder put(String urlTemplate, Object... urlVariables)
	{
		return MockMvcRequestBuilders.put(urlTemplate, urlVariables).servletPath(SoftdesignPathConstants.REST_API);
	}
}
