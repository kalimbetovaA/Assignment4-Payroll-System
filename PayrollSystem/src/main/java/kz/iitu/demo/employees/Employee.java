package kz.iitu.demo.employees;

public abstract class Employee {
    int empId;
    String EmpName;
    double totalWeeklySalary;

    public Employee() {
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setTotalWeeklySalary(double totalWeeklySalary) {
        this.totalWeeklySalary = totalWeeklySalary;
    }

    public double getTotalWeeklySalary() {
        return totalWeeklySalary;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

}
