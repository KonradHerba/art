package com.amartus.service;

import com.amartus.domain.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by khe on 2017-02-16.
 */
public interface EmployeeService {
    void addEmployee(Employee employee);
    Set<Employee> getAllEmployees();
    Set<Employee> getEmployeeByMail(String email);
    Set<Employee> getEmployeeByCriteria(Map<String, List<String>> filterCriteria);
}
