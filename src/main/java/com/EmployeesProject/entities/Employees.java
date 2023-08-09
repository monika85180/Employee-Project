package com.EmployeesProject.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String empName;
    private String department;
    private double amount;
    private String currency;
    private String joiningDate;
    private String exitDate;



}
