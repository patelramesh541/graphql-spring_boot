package com.ramesh.graphql.graphql_demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ramesh.graphql.graphql_demo.model.Company;
import com.ramesh.graphql.graphql_demo.model.Employee;
import com.ramesh.graphql.graphql_demo.service.CompanyService;
import com.ramesh.graphql.graphql_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    public Company getCompanyById(Integer cId) {
        return companyService.getCompanyById(cId);
    }

    public Employee getEmployeeById(Integer empId) {
        return employeeService.getEmployeeById(empId);
    }


}
