package com.carloscorp.clientservice.services;

import com.carloscorp.clientservice.dto.ClientDto;
import com.carloscorp.clientservice.exceptions.NotFoundException;
import com.carloscorp.clientservice.integrations.dto.AccountDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> getClients();

    ClientDto getClientByEmail(String email) throws NotFoundException;

    List<AccountDto> getAccounts(Long clientId);
}
