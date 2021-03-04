package kz.iitu.demo.service.impl;

import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;
import kz.iitu.demo.events.SalaryChangeEvent;
import kz.iitu.demo.repository.EmployeeRepository;
import kz.iitu.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService, ApplicationEventPublisherAware {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getAll() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC,"name"));
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByType(EmployeeType employeeType) {
        return employeeRepository.findByEmplType(employeeType);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElse(new Employee());
    }



    @Override
    public void updateFixedSalary(Long id, double newSalary) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isPresent()) {
            Employee dbEmployee=employeeOptional.get();
            dbEmployee.setFixedSalary(newSalary);

            employeeRepository.save(dbEmployee);

            this.eventPublisher.publishEvent(new SalaryChangeEvent(this, dbEmployee));
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
