package com.amartus.service.impl;

import com.amartus.domain.Employee;
import com.amartus.domain.repository.EmployeeRepository;
import com.amartus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by khe on 2017-02-16.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

}
