package com.EmployeesProject.controllers;

import com.EmployeesProject.payloads.CurrencyDTO;
import com.EmployeesProject.payloads.EmployeesDto;
import com.EmployeesProject.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @PostMapping("tci/employee-bonus")  //localhost:8080/tci/employee-bonus
    public ResponseEntity<List<EmployeesDto>> registerListOfEmployees(@RequestBody List<EmployeesDto> employeesDto) {
        List<EmployeesDto> employeesDtoList = employeesService.registerListOfEmployees(employeesDto);
        return new ResponseEntity<>(employeesDtoList, HttpStatus.CREATED);

    }


    @GetMapping("/tci/employees-by-currency-and-joining-date/{joiningDate}")   //localhost:8080/tci/employees-by-currency-and-joining-date/{joiningDate}
    public ResponseEntity<List<CurrencyDTO>> getEmployeesByJoiningDate(@PathVariable("joiningDate") String joiningDate) {
        List<CurrencyDTO> employeesByCurrency = employeesService.getEmployeesByJoiningDate(joiningDate);
        return ResponseEntity.ok(employeesByCurrency);
    }
}