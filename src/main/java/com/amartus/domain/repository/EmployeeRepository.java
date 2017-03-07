package com.amartus.domain.repository;

import com.amartus.domain.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by khe on 2017-01-25.
 */
public interface EmployeeRepository {
    void addEmployee(Employee employee);
    Employee getEmployeeByName(String name, String lastname);
    Set<Employee> getAllEmployees();
    Set<Employee> getEmployeeByMail(String email);
    Set<Employee> getEmployeeByCriteria(Map<String, List<String>> filterCriteria);
}
