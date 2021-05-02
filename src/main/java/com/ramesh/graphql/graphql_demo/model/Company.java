package com.ramesh.graphql.graphql_demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Entity
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    public Company() {
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "address" , nullable = false)
    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "employees")
    private List<Employee> employees;

    public Company(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(companyName, company.companyName) && Objects.equals(address, company.address) && Objects.equals(employees, company.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, address, employees);
    }
}
