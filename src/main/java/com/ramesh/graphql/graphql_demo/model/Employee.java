package com.ramesh.graphql.graphql_demo.model;


import javax.persistence.*;

import java.io.Serializable;

import java.util.Objects;
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "empName", nullable = false)
    private String empName;

    @Column(name = "salary")
    private int salary;

    @Column(name = "occupation", nullable = false)
    private String occupation;


    @ManyToOne
    @JoinColumn(name = "company", nullable = false, updatable = false)
    private Company company;


    public Employee(String empName, int salary, String occupation, Company company) {
        this.empName = empName;
        this.salary = salary;
        this.occupation = occupation;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && Objects.equals(empName, employee.empName) && Objects.equals(occupation, employee.occupation)  && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empName, salary, occupation,  company);
    }
}
