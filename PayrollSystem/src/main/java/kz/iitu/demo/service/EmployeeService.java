package kz.iitu.demo.service;

import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    void create(Employee employee);
    Page<Employee> getAll();
    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeesByType(EmployeeType employeeType);
    Employee getById(Long id);
    void updateFixedSalary(Long id, double newSalary);
}
