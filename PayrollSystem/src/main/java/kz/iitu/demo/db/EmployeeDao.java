package kz.iitu.demo.db;

import kz.iitu.demo.employees.Employee;
import kz.iitu.demo.employees.SalariedCommissionEmp;
import kz.iitu.demo.events.SalaryChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao implements ApplicationEventPublisherAware {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeRawMapper employeeRawMapper;
    private ApplicationEventPublisher eventPublisher;


    public List<Employee> getEmployees(String type) {
        String query="SELECT * FROM employees, "+type+"empreports where employees.id="+type+"empreports.empId";
        return jdbcTemplate.query(query, employeeRawMapper);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> allEmp=getEmployees("salariedCommission");
        allEmp.addAll(getEmployees("salaried"));
        allEmp.addAll(getEmployees("hourly"));
        allEmp.addAll(getEmployees("commission"));
        return allEmp;
    }


    public int updateBaseSalary(SalariedCommissionEmp emp, float percent){
        double newSalary=(emp.getBaseSalary() + emp.getBaseSalary()*(percent/100));
        String query="update salariedcommissionempreports set baseSalary="+newSalary+" where empId="+emp.getEmpId()+" ";
        int result=jdbcTemplate.update(query);
        emp.setBaseSalary(newSalary);

        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, emp, "baseSalary", newSalary));
        return result;
    }

    public void updateAllBaseSalaries(float percent){
        for (Employee e: getEmployees("salariedcommission")) {
            updateBaseSalary((SalariedCommissionEmp) e, percent);
        }
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
