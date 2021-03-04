package kz.iitu.demo.calculator;

import kz.iitu.demo.controller.EmployeeController;
import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;
import kz.iitu.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalaryCalculatorService {

    @Autowired
    private EmployeeController employeeController;


    public double calcSalary(Employee e){
        double totalWeeklySalary=0;
        if(e.getEmplType().equals(EmployeeType.SALARIED)){
            totalWeeklySalary=(e.getHoursWorked()/40)* e.getFixedSalary()/4;
        }
        else if(e.getEmplType().equals(EmployeeType.HOURLY)){
            int overtime=e.getHoursWorked()-40;
            totalWeeklySalary=40*e.getHourRate() + (e.getHourRate()*1.5)*overtime;
        }
        else if(e.getEmplType().equals(EmployeeType.COMMISION)){
            totalWeeklySalary=e.getSales()*e.getCommRate()/100;
        }
        else if(e.getEmplType().equals(EmployeeType.SALARIED_COMMISION)){
            totalWeeklySalary=(e.getSales()*e.getCommRate()/100)+(e.getFixedSalary()/4);
        }
        return totalWeeklySalary;
    }


    public double calcAllEmpSalary(){
        double totalSalary=0;
        List<Employee> allEmp=employeeController.getAll().getContent();

        for (Employee e:allEmp) {
            totalSalary+=calcSalary(e);
        }
        return totalSalary;
    }

    public double calcEmpSalaryByType(EmployeeType employeeType){
        double totalSalary=0;
        List<Employee> employees= employeeController.getEmployeesByType(employeeType);

        for (Employee e:employees) {
            totalSalary+=calcSalary(e);
        }
        return totalSalary;
    }

}
