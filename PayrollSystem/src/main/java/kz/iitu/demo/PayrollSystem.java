package kz.iitu.demo;

import kz.iitu.demo.calculator.SalaryCalculatorService;
import kz.iitu.demo.db.EmployeeDao;
import kz.iitu.demo.employees.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class PayrollSystem {
    Scanner sc=new Scanner(System.in);

    @Autowired
    SalaryCalculatorService calculator;
    @Autowired
    EmployeeDao employeeDao;

    public void showMenu(){

        while (true) {
            System.out.println("What do you want to do: ");
            System.out.println("1 - Calculate ALL Employees total salary\n" +
                    "2 - Calculate CERTAIN type of employees total salary\n" +
                    "3 - Calculate CERTAIN Employee weekly salary\n" +
                    "4 - Reward salaried-commission employees\n" +
                    "0 - exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("ALL Employees total salary: "+calculator.calcAllEmpSalary());
                    break;
                case 2:
                    getCertainTypeTotalSalary();
                    break;
                case 3:
                    getEmployeeWeeklySalary();
                    break;
                case 4:
                    rewardSalariedCommission();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void getCertainTypeTotalSalary(){
        System.out.println("Choose type of employees");
        System.out.println("1 - Salaried employees\n" +
                "2 - Hourly employees\n" +
                "3 - Commission employees\n" +
                "4 - Salaried-commission employees");
        int choice = sc.nextInt();
        String type=null;
        switch (choice){
            case 1:
                type="salaried";
                break;
            case 2:
                type="hourly";
                break;
            case 3:
                type="commission";
                break;
            case 4:
                type="salariedCommission";
                break;
            case 0:
                break;

        }
        System.out.println("Total Weekly Salary of "+type+" employees: "+calculator.calcEmpSalaryByType(type));
    }

    public void getEmployeeWeeklySalary(){
        System.out.println("Choose employee: ");
        List<Employee> employees= employeeDao.getAllEmployees();
        int i=1;
        for (Employee e:employees) {
            System.out.println(i+") "+e.getEmpName());
            i++;
        }
        Employee e = employees.get(sc.nextInt()-1);
        double weeklySalary=calculator.calcSalary(e);
        System.out.println("Weekly salary of "+e.getEmpName()+" = "+weeklySalary);
    }

    public void rewardSalariedCommission(){
        System.out.println("how much do you want to add to Base Salary?(%)");
        float percent= sc.nextInt();
        employeeDao.updateAllBaseSalaries(percent);
        System.out.println("Base Salary successfully updated!");
    }

}
