package com.carloscorp.clientservice.controllers;

import com.carloscorp.clientservice.dto.ClientDto;
import com.carloscorp.clientservice.exceptions.NotFoundException;
import com.carloscorp.clientservice.integrations.dto.AccountDto;
import com.carloscorp.clientservice.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients(){
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<ClientDto> getClientByEmail(@RequestParam String email) throws NotFoundException {
        return new ResponseEntity<>(clientService.getClientByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/{id}/accounts")
    public ResponseEntity<List<AccountDto>> getClientAccounts(@PathVariable Long id){
        return new ResponseEntity<>(clientService.getAccounts(id), HttpStatus.OK);
    }
}
