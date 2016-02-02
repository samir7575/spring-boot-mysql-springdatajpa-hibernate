package com.softdesign.dao;

import org.springframework.data.repository.CrudRepository;

import com.softdesign.domain.Client;

/**
 * Repository des clients
 * @author malek
 *
 */
public interface ClientDAO extends CrudRepository<Client, Long>
{

}
