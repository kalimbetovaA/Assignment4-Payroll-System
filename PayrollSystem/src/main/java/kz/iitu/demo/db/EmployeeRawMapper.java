package kz.iitu.demo.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import kz.iitu.demo.employees.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRawMapper  implements RowMapper<Employee>{

    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee=null;
        switch (resultSet.getString("type")){
            case "commission":
                employee = new CommissionEmp();
                ((CommissionEmp) employee).setSales(resultSet.getDouble("sales"));
                ((CommissionEmp) employee).setPercentage(resultSet.getInt("percentage"));
                break;
            case "hourly":
                employee = new HourlyEmp();
                ((HourlyEmp) employee).setHourlySalary(resultSet.getDouble("hourlySalary"));
                ((HourlyEmp) employee).setWorkedHours(resultSet.getInt("workedHours"));
                ((HourlyEmp) employee).setCoef(resultSet.getFloat("coef"));
                break;
            case "salaried":
                employee = new SalariedEmp();
                ((SalariedEmp) employee).setMonthlySalary(resultSet.getDouble("monthlySalary"));
                ((SalariedEmp) employee).setWorkedHours(resultSet.getInt("workedHours"));
                break;
            case "salariedcommission":
                employee = new SalariedCommissionEmp();
                ((SalariedCommissionEmp) employee).setBaseSalary(resultSet.getDouble("baseSalary"));
                ((SalariedCommissionEmp) employee).setSales(resultSet.getDouble("sales"));
                ((SalariedCommissionEmp) employee).setPercentage(resultSet.getInt("percentage"));
                break;
        }
        employee.setEmpId(resultSet.getInt("id"));
        employee.setEmpName(resultSet.getString("fullname"));
        return employee;
    }
}
