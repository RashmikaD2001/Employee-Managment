package com.company.empmgmtsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.empmgmtsystem.model.Employee;
import com.company.empmgmtsystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Optional<Employee> searchEmployee(Long Id){
        return employeeRepository.findById(Id);
    }

    public Employee updateEmployee(Long id, Employee employee){
        Optional<Employee> resultEmployee = searchEmployee(id);
        if(resultEmployee.isPresent()){
            Employee existingEmployee = resultEmployee.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPosition(employee.getPosition());
            existingEmployee.setSalary(employee.getSalary());
            employeeRepository.save(existingEmployee);
            return existingEmployee;
        }else{
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public void deleteEmployee(Long Id){
        employeeRepository.deleteById(Id);
    }
}
