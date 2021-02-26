package kz.iitu.demo.employees;

import kz.iitu.demo.employees.Employee;

public class CommissionEmp extends Employee {
    double sales;
    int percentage;


    public CommissionEmp() {
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public double getSales() {
        return sales;
    }

    public int getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "CommissionEmp{" +
                "sales=" + sales +
                ", percentage=" + percentage +
                ", totalWeeklySalary=" + totalWeeklySalary +
                ", empId=" + empId +
                ", EmpName='" + EmpName + '\'' +
                '}';
    }
}
