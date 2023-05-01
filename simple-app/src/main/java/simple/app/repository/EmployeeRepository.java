package simple.app.repository;

import simple.app.domain.Department;
import simple.app.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Repository

public class EmployeeRepository {
    private DataSource dataSource;
    private static final String ALL = "select * from employees";
    private static final String CREATE = "INSERT INTO employees (name, isStaff, joiningDate, annualLeaves, sickLeaves) \n" +
            "VALUES (?, ?, ?, ?, ?);\n";
    public EmployeeRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Employee> list() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(ALL);
        return mapper(resultSet);
    }

    private List<Employee> mapper(ResultSet resultSet) throws SQLException {
        List<Employee> employees = new ArrayList<Employee>();
        while(resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getLong(1));
            employee.setName(resultSet.getString(2));
            employee.setIsStaff(resultSet.getBoolean(3));
            employee.setJoiningDate(resultSet.getDate(4));
            employee.setAnnualLeaves(resultSet.getLong(5));
            employee.setSickLeaves(resultSet.getLong(6));
            employees.add(employee);
        }
        return employees;
    }

    public boolean create(Employee employee) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setBoolean(2, employee.getIsStaff());
        preparedStatement.setDate(3, new java.sql.Date(employee.getJoiningDate().getTime()));
        preparedStatement.setLong(4, employee.getAnnualLeaves());
        preparedStatement.setLong(5, employee.getSickLeaves());
        return preparedStatement.execute();
    }
}
