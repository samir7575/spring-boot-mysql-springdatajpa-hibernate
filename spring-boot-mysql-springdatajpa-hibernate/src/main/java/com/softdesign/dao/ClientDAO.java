package com.softdesign.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.softdesign.domain.Client;

/**
 * Repository des clients
 * @author malek
 *
 */
@Transactional
public interface ClientDAO extends CrudRepository<Client, Long>
{

}
