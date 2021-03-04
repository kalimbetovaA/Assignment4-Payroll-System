package kz.iitu.demo.controller;

import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;
import kz.iitu.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public Page<Employee> getAll() {
        return employeeService.getAll();
    }

    public List<Employee> getEmployeesByType(EmployeeType employeeType) {
        return employeeService.getEmployeesByType(employeeType);
    }

    public void updateFixedSalary(Long id, double newSalary){
        employeeService.updateFixedSalary(id, newSalary);
    }


}
