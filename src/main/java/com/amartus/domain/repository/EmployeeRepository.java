package com.amartus.domain.repository;

import com.amartus.domain.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by khe on 2017-01-25.
 */
public interface EmployeeRepository {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    List<Employee> getEmployeeByMail(String email);
    List<Employee> getEmployeeByCriteria(Map<String, List<String>> filterCriteria);
}
