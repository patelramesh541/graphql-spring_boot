package com.ramesh.graphql.graphql_demo.service;

import com.ramesh.graphql.graphql_demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer empId);

    Employee createEmployee(String empName, Integer salary, String occupation, Integer company);
}
