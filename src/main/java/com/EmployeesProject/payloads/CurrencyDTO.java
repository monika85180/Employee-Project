package com.EmployeesProject.payloads;

import lombok.Data;

import java.util.List;

@Data
public class CurrencyDTO {
    private String currency;
    private List<EmployeDTO> employees;
}
