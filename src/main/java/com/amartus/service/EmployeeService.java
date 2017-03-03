package com.amartus.service;

import com.amartus.domain.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by khe on 2017-02-16.
 */
public interface EmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    List<Employee> getEmployeeByMail(String email);
    List<Employee> getEmployeeByCriteria(Map<String, List<String>> filterCriteria);
}
