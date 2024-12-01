package com.carloscorp.clientservice.services.impl;

import com.carloscorp.clientservice.dto.ClientDto;
import com.carloscorp.clientservice.entity.Client;
import com.carloscorp.clientservice.exceptions.NotFoundException;
import com.carloscorp.clientservice.integrations.BankAccountClient;
import com.carloscorp.clientservice.integrations.dto.AccountDto;
import com.carloscorp.clientservice.repository.ClientRepository;
import com.carloscorp.clientservice.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final BankAccountClient bankAccountClient;
    private final Environment environment;

    @Override
    public List<ClientDto> getClients(){
        return clientRepository.findAll().stream()
                .map(this::buildDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientByEmail(String email) throws NotFoundException {
        return clientRepository.findByEmail(email)
                .map(this::buildDto)
                .orElseThrow(() -> new NotFoundException("Client with email " + email + " not found"));
    }

    @Override
    public List<AccountDto> getAccounts(Long clientId){
        return bankAccountClient.getClientAccounts(clientId);
    }

    private ClientDto buildDto(Client client) {
        if (client==null){
            return null;
        }
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setEmail(client.getEmail());
        dto.setFullName(client.getFullName());
        dto.setAddress(client.getAddress());
        dto.setBirthDate(client.getBirthDate());
        dto.setEnvironment(getEnvironmentData());

        return dto;
    }

    private String getEnvironmentData() {
        String port = environment.getProperty("local.server.port");
        String host = environment.getProperty("HOSTNAME");
        String version = "v0.0.4";
        return port + " " + version + " " + host;
    }
}
