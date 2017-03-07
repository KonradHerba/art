package com.amartus.service.impl;

import com.amartus.domain.Employee;
import com.amartus.domain.repository.EmployeeRepository;
import com.amartus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by khe on 2017-02-16.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Set<Employee> getEmployeeByMail(String email) {

        //We need to add '.com' at the end of the email address.
        //It is a Spring desired behavoiur. Sprint removes everything after
        // last dot including this dot.
        email += ".com";

        return employeeRepository.getEmployeeByMail(email);
    }

    @Override
    public Set<Employee> getEmployeeByCriteria(Map<String, List<String>> filterCriteria) {
        return employeeRepository.getEmployeeByCriteria(filterCriteria);
    }
}
