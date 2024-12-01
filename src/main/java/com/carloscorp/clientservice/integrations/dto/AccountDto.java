package com.carloscorp.clientservice.integrations.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDto {

    private Long id;

    private String accountNumber;

    private String accountType;

    private Long clientId;

    private Double funds;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    private String environment;
}
