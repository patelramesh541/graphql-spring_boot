package com.ramesh.graphql.graphql_demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ramesh.graphql.graphql_demo.model.Company;
import com.ramesh.graphql.graphql_demo.model.Employee;
import com.ramesh.graphql.graphql_demo.service.CompanyService;
import com.ramesh.graphql.graphql_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    public Company createCompany(String companyName, String address) {
        return companyService.createCompany(companyName,address);
    }


    public Employee createEmployee(String empName, Integer salary, String occupation, Integer company) {
        return employeeService.createEmployee(empName,salary,occupation,company);
    }

}
