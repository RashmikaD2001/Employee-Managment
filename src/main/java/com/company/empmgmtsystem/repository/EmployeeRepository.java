package com.company.empmgmtsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.empmgmtsystem.model.Employee;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee,Long>{

}
