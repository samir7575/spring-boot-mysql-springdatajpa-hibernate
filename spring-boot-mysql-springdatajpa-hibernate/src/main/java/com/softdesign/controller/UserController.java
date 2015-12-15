package com.softdesign.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.dao.UserDAO;
import com.softdesign.domain.User;
import com.softdesign.tools.BlowfishAlgoBCRYPT;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "UserController", description = "Service Rest de l'utilisateur")
public class UserController
{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO userDAO;

	/**
	 * GET /create --> Create a new user and save it in the database.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = RestMediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Créer un utilisateur avec un email et un nom.")
	public String create(
		@RequestParam("email") String email,
		@RequestParam("name") String name,
		@RequestParam("password") String password,
		HttpServletRequest request)
	{
		LOGGER.info("Invoking create with user = {}, and email {}", name, email);
		LOGGER.info("" + request);
		User user = null;
		try
		{
			String hashedPassword = BlowfishAlgoBCRYPT.bcCrypt(password);
			user = new User(email, name, hashedPassword);
			userDAO.save(user);
		} catch (Exception ex)
		{
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created! (id = " + user.getId() + ")";
	}

	/**
	 * GET /delete --> Delete the user having the passed id.
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = RestMediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Supprimer un utilisateur.")
	public String deleteUser(@RequestParam("idUser") long idUser,
		HttpServletRequest request)
	{
		LOGGER.info("Invoking deleteUser for user ={}", idUser);
		LOGGER.info(request + "");
		try
		{
			User user = new User(idUser);
			userDAO.delete(user);
		} catch (Exception ex)
		{
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

	/**
	 * GET /get-by-email --> Return the id for the user having the passed email.
	 */
	@RequestMapping(value = "/get-by-email", method = RequestMethod.GET, produces = RestMediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Récupérer un utilisateur à partir de son email.")
	public User getUserByEmail(@RequestParam("email") String email, HttpServletRequest request)
	{
		LOGGER.info("Invoking getUserByEmail for user with email ={}", email);
		LOGGER.info(request + "");
		User user = null;
		try
		{
			user = userDAO.findByEmail(email);
		} catch (Exception ex)
		{
			return null;
		}
		return user;
	}

	/**
	 * GET /update --> Update the email and the name for the user in the database having the passed id.
	 */

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = RestMediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Mettre à jour le nom et l'email d'un utilisateur.")
	public String updateUser(
		@RequestParam("idUser") long idUser,
		@RequestParam("email") String email,
		@RequestParam("name") String name, HttpServletRequest request)
	{
		LOGGER.info("Invoking updateUser for user with id ={} by new name {} and new email {}", idUser, name, email);
		LOGGER.info(request + "");
		try
		{
			User user = userDAO.findOne(idUser);
			user.setEmail(email);
			user.setName(name);
			userDAO.save(user);
		} catch (Exception ex)
		{
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

}
