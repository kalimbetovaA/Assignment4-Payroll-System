package kz.iitu.demo.calculator;

import kz.iitu.demo.db.EmployeeDao;
import kz.iitu.demo.employees.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalaryCalculatorService {

    @Autowired
    private EmployeeDao employeeDao;

    public double calcSalary(Employee emp){
        double totalWeeklySalary=0;
        if(emp instanceof SalariedEmp){
            SalariedEmp e = (SalariedEmp) emp;
            totalWeeklySalary=(e.getWorkedHours()/40)* e.getMonthlySalary()/4;
        }
        else if(emp instanceof HourlyEmp){
            HourlyEmp e = (HourlyEmp) emp;
            int overtime=e.getWorkedHours()-40;
            totalWeeklySalary=40*e.getHourlySalary() + (e.getHourlySalary()*1.5)*overtime;
        }
        else if(emp instanceof CommissionEmp){
            CommissionEmp e = (CommissionEmp) emp;
            totalWeeklySalary=e.getSales()*e.getPercentage()/100;
        }
        else if(emp instanceof SalariedCommissionEmp){
            SalariedCommissionEmp e = (SalariedCommissionEmp) emp;
            totalWeeklySalary=(e.getSales()*e.getPercentage()/100)+(e.getBaseSalary()/4);
        }
        emp.setTotalWeeklySalary(totalWeeklySalary);
        return totalWeeklySalary;
    }


    public double calcAllEmpSalary(){
        double totalSalary=0;
        List<Employee> allEmp=employeeDao.getAllEmployees();

        for (Employee e:allEmp) {
            totalSalary+=calcSalary(e);
        }
        return totalSalary;
    }

    public double calcEmpSalaryByType(String empType){
        double totalSalary=0;
        List<Employee> employees=employeeDao.getEmployees(empType);

        for (Employee e:employees) {
            totalSalary+=calcSalary(e);
        }
        return totalSalary;
    }

}
