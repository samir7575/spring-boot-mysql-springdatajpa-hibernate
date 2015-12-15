package com.softdesign.controller;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.tools.BlowfishAlgoBCRYPT;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "AuthenticationController", description = "Service d'authentification")
public class AuthenticationController
{

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@RequestMapping(value = "/authticate", method = RequestMethod.POST, produces = RestMediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Authentification de l'utilisateur.")
	public String authenticate(@RequestParam("login") String login,
		@RequestParam("password") String password,
		HttpServletRequest request)
	{
		LOGGER.info("invoking authenticate user with login : {}, password {}", login, "****");
		if (login != null && password != null && request != null)
		{
			// Vérification d'un mot de passe à partir du hash

			String candidate = null;
			if (BCrypt.checkpw(candidate, BlowfishAlgoBCRYPT.bcCrypt(password)))
				System.out.println("It matches");
			else
				System.out.println("It does not match");
		}
		return null;

	}
}
