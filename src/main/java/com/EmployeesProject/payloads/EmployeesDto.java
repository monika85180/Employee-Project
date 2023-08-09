package com.EmployeesProject.payloads;

import com.EmployeesProject.entities.Employees;
import lombok.Data;

@Data
public class EmployeesDto extends Employees {
    private long id;
    private String empName;
    private String department;
    private double amount;
    private String currency;
    private String joiningDate;
    private String exitDate;

}
