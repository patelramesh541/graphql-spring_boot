package com.ramesh.graphql.graphql_demo.service.impl;

import com.ramesh.graphql.graphql_demo.dao.CompanyDAO;
import com.ramesh.graphql.graphql_demo.dao.EmployeeDAO;
import com.ramesh.graphql.graphql_demo.model.Company;
import com.ramesh.graphql.graphql_demo.model.Employee;
import com.ramesh.graphql.graphql_demo.service.CompanyService;
import com.ramesh.graphql.graphql_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {



    @Autowired
    private CompanyDAO companyDAO;




    @Override
    @Transactional(readOnly = true)
    public List<Company> getCompanies() {
        return companyDAO.findAll();
    }



    @Override
    @Transactional(readOnly = true)
    public Company getCompanyById(Integer cId) {
        return companyDAO.findById(cId).orElseThrow(() -> new IllegalArgumentException(" company id not found !"));
    }

    @Override
    @Transactional
    public Company createCompany(String companyName, String address) {

        return companyDAO.save(new Company(companyName,address));
    }


}
