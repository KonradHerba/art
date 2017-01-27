package com.amartus.service;

import com.amartus.domain.Employee;
import com.amartus.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by khe on 2017-01-27.
 */
@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    EmployeeRepository employeeRepository;

    public void sendEmail (Employee employee) {
        //here I send email to an employee
        //this is a dummy impl for sake of edu only
        employeeRepository.getEmployeeEmail(employee);
    }
}
