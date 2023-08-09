package com.EmployeesProject.services;



import com.EmployeesProject.entities.Employees;
import com.EmployeesProject.payloads.CurrencyDTO;
import com.EmployeesProject.payloads.EmployeDTO;
import com.EmployeesProject.payloads.EmployeesDto;
import com.EmployeesProject.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepo;



    public List<EmployeesDto> registerListOfEmployees(List<EmployeesDto> employeesDto){
        List<Employees> employeesList = mapToEmployees(employeesDto);
        List<Employees> savedEmployeesList = employeesRepo.saveAll(employeesList);
        return mapToEmployeesDto(savedEmployeesList);
    }


    public List<CurrencyDTO> getEmployeesByJoiningDate(String joiningDate) {
        List<CurrencyDTO> result = new ArrayList<>();

        List<String> currencies = employeesRepo.findDistinctCurrencies();
        for (String currency : currencies) {
            CurrencyDTO currencyDTO = new CurrencyDTO();
            currencyDTO.setCurrency(currency);

            List<Employees> employees = employeesRepo.findEmployeesByJoiningDate( joiningDate);
            List<EmployeDTO> employeeDTOs = new ArrayList<>();
            for (Employees employee : employees) {
                EmployeDTO employeeDTO = new EmployeDTO();
                employeeDTO.setEmpName(employee.getEmpName());
                employeeDTO.setAmount(employee.getAmount());
                employeeDTOs.add(employeeDTO);
            }

            currencyDTO.setEmployees(employeeDTOs);
            result.add(currencyDTO);
        }

        return result;
    }



    public List<EmployeesDto> mapToEmployeesDto(List<Employees> employeesList) {
        List<EmployeesDto> employeesDtoList = new ArrayList<>();

        for (Employees employee : employeesList) {
            EmployeesDto employeesDto = new EmployeesDto();
            employeesDto.setId(employee.getId());
            employeesDto.setEmpName(employee.getEmpName());
            employeesDto.setDepartment(employee.getDepartment());
            employeesDto.setAmount(employee.getAmount());
            employeesDto.setCurrency(employee.getCurrency());
            employeesDto.setJoiningDate(employee.getJoiningDate());
            employeesDto.setExitDate(employee.getExitDate());

            employeesDtoList.add(employeesDto);
        }

        return employeesDtoList;
    }


    private List<Employees> mapToEmployees(List<EmployeesDto> employeesDto) {
        List<Employees> employeesList = new ArrayList<>();

        for(EmployeesDto employeesDtoList : employeesDto){
            Employees employees = new Employees();
            employees.setEmpName(employeesDtoList.getEmpName());
            employees.setDepartment(employeesDtoList.getDepartment());
            employees.setAmount(employeesDtoList.getAmount());
            employees.setCurrency(employeesDtoList.getCurrency());
            employees.setJoiningDate(employeesDtoList.getJoiningDate());
            employees.setExitDate(employeesDtoList.getExitDate());

            employeesList.add(employees);
        }
        return employeesList;
    }


}
