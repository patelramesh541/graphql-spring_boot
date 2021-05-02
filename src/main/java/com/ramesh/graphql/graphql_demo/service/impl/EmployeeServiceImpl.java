package com.ramesh.graphql.graphql_demo.service.impl;

import com.ramesh.graphql.graphql_demo.dao.CompanyDAO;
import com.ramesh.graphql.graphql_demo.dao.EmployeeDAO;
import com.ramesh.graphql.graphql_demo.model.Company;
import com.ramesh.graphql.graphql_demo.model.Employee;
import com.ramesh.graphql.graphql_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private CompanyDAO companyDAO;


    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Employee getEmployeeById(Integer empId) {
        return employeeDAO.findById(empId).orElseThrow(() -> new IllegalArgumentException(" employee id not found !"));
    }


    @Override
    @Transactional
    public Employee createEmployee(String empName, Integer salary, String occupation, Integer cmpId) {
        Optional<Company> companyObj = companyDAO.findById(cmpId);
        Company company = companyObj.get();
        return employeeDAO.save(new Employee(empName, salary, occupation, company));
    }
}
