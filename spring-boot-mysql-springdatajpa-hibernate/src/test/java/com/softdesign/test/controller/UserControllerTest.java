package com.softdesign.test.controller;

import static com.softdesign.test.controller.RestApiMockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MvcResult;

public class UserControllerTest extends AbstractSpringMVCControllerTest
{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);

	@Test
	public void testGetUserByEmail() throws Exception
	{
		MvcResult rest = mockMvc
			.perform(
				get(
					"/users/get-by-email").param("email", "abdelmalik.aoudia@gmail.com")
						.accept(mediaType))
			.andExpect(status().isOk())
			.andReturn();

		LOGGER.debug("getUserByEmail resp = {}", rest.getResponse().getContentType());
	}
}
