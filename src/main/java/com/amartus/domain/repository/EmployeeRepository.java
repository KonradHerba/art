package com.amartus.domain.repository;

import com.amartus.domain.Employee;

import java.util.List;

/**
 * Created by khe on 2017-01-25.
 */
public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    String getEmployeeEmail (Employee employee);
}
