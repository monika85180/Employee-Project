package com.EmployeesProject.repositories;

import com.EmployeesProject.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {



    @Query("SELECT DISTINCT e.currency FROM Employees e")
    List<String> findDistinctCurrencies();

    List<Employees> findByCurrency(String currency);

    List<Employees> findEmployeesByJoiningDate(String joiningDate);

}
