package com.softdesign.convertor.basic;

import org.springframework.stereotype.Component;

import com.softdesign.domain.Client;
import com.softdesign.dto.basic.ClientDTO;

@Component("clientConvertor")
public class ClientConvertor extends BasicConvertor<Client, ClientDTO>
{

}
