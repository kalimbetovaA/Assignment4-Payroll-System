package kz.iitu.demo.employees;

import kz.iitu.demo.employees.Employee;

public class SalariedCommissionEmp  extends Employee {
    double sales;
    int percentage;
    double baseSalary;

    public SalariedCommissionEmp() {
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }


    public double getSales() {
        return sales;
    }

    public int getPercentage() {
        return percentage;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "SalariedCommissionEmp{" +
                "sales=" + sales +
                ", percentage=" + percentage +
                ", baseSalary=" + baseSalary +
                ", totalWeeklySalary=" + totalWeeklySalary +
                ", empId=" + empId +
                ", EmpName='" + EmpName + '\'' +
                '}';
    }
}


