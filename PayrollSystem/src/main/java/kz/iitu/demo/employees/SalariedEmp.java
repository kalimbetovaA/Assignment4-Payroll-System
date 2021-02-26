package kz.iitu.demo.employees;

import kz.iitu.demo.employees.Employee;

public class SalariedEmp extends Employee {
    double monthlySalary;
    int workedHours;

    public SalariedEmp() {
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    @Override
    public String toString() {
        return "SalariedEmp{" +
                "monthlySalary=" + monthlySalary +
                ", workedHours=" + workedHours +
                ", totalWeeklySalary=" + totalWeeklySalary +
                ", empId=" + empId +
                ", EmpName='" + EmpName + '\'' +
                '}';
    }
}
