package kz.iitu.demo.events;

import kz.iitu.demo.employees.Employee;
import org.springframework.context.ApplicationEvent;

public class SalaryChangeEvent extends ApplicationEvent {

    private Employee employee;
    private String updatedField;
    private double updatedValue;


    public SalaryChangeEvent(Object source, Employee employee, String updatedField, double updatedValue) {
        super(source);
        this.employee = employee;
        this.updatedField = updatedField;
        this.updatedValue = updatedValue;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getUpdatedField() {
        return updatedField;
    }

    public double getUpdatedValue() {
        return updatedValue;
    }
}