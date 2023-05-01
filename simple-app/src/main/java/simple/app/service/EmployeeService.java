package simple.app.service;

import org.springframework.stereotype.Service;
import simple.app.domain.Department;
import simple.app.domain.Employee;
import simple.app.repository.EmployeeRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> list() throws SQLException {
        return employeeRepository.list();
    }

    public boolean create(Employee employee) throws SQLException {
        employee.setName(employee.getName().toUpperCase());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate joiningDate = employee.getJoiningDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long daysRemaining = ChronoUnit.DAYS.between(joiningDate, joiningDate.withDayOfYear(365));

        long annual;
        long sick;
        boolean t = employee.getIsStaff();
        if(t==true){
            annual = (long) Math.round((daysRemaining * 0.0273));
            sick = (long) Math.round((daysRemaining * 0.01917));
        }
        else {
            annual = (long) Math.round((daysRemaining * 0.041));
            sick = (long) Math.round((daysRemaining * 0.0273));
        }
        System.out.println(annual);
        employee.setAnnualLeaves(annual);
        employee.setSickLeaves(sick);

        return employeeRepository.create(employee);
    }
}
