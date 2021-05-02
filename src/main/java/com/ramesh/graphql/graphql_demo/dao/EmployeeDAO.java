package com.ramesh.graphql.graphql_demo.dao;

import com.ramesh.graphql.graphql_demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer> {
}
