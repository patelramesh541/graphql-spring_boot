package com.ramesh.graphql.graphql_demo.service;

import com.ramesh.graphql.graphql_demo.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getCompanies();

    Company getCompanyById(Integer cId);

    Company createCompany(String companyName, String address);
}
