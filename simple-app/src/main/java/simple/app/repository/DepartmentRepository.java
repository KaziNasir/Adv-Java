package simple.app.repository;

import simple.app.domain.Department;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private DataSource dataSource;
    private static final String ALL = "select id, name from departments";
    private static final String SELECT_ONE = "select id, name from departments where id = ?";
    private static final String CREATE = "insert into departments (name) values (?)";
    private static final String UPDATE = "update departments set name = ? where id = ?";
    private static final String DELETE = "delete from departments where id = ?";
    public DepartmentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Department> list() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(ALL);
        return mapper(resultSet);
    }
    public Department get(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Department department = new Department();
        while (resultSet.next()) {
            department.setId(resultSet.getLong(1));
            department.setName(resultSet.getString(2));
        }
        return department;
    }
    public boolean create(Department department) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, department.getName());
        return preparedStatement.execute();
    }
    public boolean update(Department department) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, department.getName());
        preparedStatement.setLong(2, department.getId());
        return preparedStatement.execute();
    }

    public boolean delete(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setLong(1, id);
        return preparedStatement.execute();
    }

    private List<Department> mapper(ResultSet resultSet) throws SQLException {
        List<Department> departments = new ArrayList<Department>();
        while(resultSet.next()) {
            Department department = new Department();
            department.setId(resultSet.getLong(1));
            department.setName(resultSet.getString(2));
            departments.add(department);
        }
        return departments;
    }
}
