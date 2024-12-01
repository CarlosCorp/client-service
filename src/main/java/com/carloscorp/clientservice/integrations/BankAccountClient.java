package com.carloscorp.clientservice.integrations;


import com.carloscorp.clientservice.config.FeignConfig;
import com.carloscorp.clientservice.integrations.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "bank-account-service", url = "${BANK_ACCOUNT_SERVICE_URI:http://localhost}:8100" ,
        configuration = FeignConfig.class)
public interface BankAccountClient {

    @GetMapping("/accounts/client/{client_id}")
    List<AccountDto> getClientAccounts(@PathVariable Long client_id);
}
