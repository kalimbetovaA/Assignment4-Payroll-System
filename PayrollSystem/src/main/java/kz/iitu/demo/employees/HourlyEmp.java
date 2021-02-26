package kz.iitu.demo.employees;

import kz.iitu.demo.employees.Employee;

public class HourlyEmp extends Employee {
    double hourlySalary;
    int workedHours;
    float coef;

    public HourlyEmp() {
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public float getCoef() {
        return coef;
    }

    @Override
    public String toString() {
        return "HourlyEmp{" +
                "hourlySalary=" + hourlySalary +
                ", workedHours=" + workedHours +
                ", coef=" + coef +
                ", totalWeeklySalary=" + totalWeeklySalary +
                ", empId=" + empId +
                ", EmpName='" + EmpName + '\'' +
                '}';
    }
}