package com.softdesign.dao;

import org.springframework.data.repository.CrudRepository;

import com.softdesign.domain.Client;

public interface ClientDAO extends CrudRepository<Client, Long>
{

}
