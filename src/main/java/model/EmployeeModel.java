package model;

import entity.Employee;
import util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {
    public boolean register(Employee emp) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.err.println("Can not open connection to database.");
                return false;
            }
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("insert into employees");
            sqlBuilder.append(" ");
            sqlBuilder.append("(name, address, email, username, password, createdAt, updatedAt, status)");
            sqlBuilder.append(" ");
            sqlBuilder.append("values");
            sqlBuilder.append(" ");
            sqlBuilder.append("(?, ?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement preparedStatement = cnn.prepareStatement(sqlBuilder.toString());
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getAddress());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getUsername());
            preparedStatement.setString(5, emp.getPassword());
            preparedStatement.setString(6, emp.getCreatedAtString());
            preparedStatement.setString(7, emp.getUpdatedAtString());
            preparedStatement.setInt(8, emp.getStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    public boolean checkExistAccount(String username) {
        try {
            Connection cnn = null;
            cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.err.println("Can not open connection to database.");
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select * from employees where username =");
            stringBuilder.append(" ");
            stringBuilder.append("?");
            PreparedStatement preparedStatement = cnn.prepareStatement(stringBuilder.toString());
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    public Employee login(String username, String password) {
        Employee employee = new Employee();
        try {
            Connection cnn = null;
            cnn = ConnectionHelper.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select * from employees where username =");
            stringBuilder.append(" ");
            stringBuilder.append("?");
            stringBuilder.append(" ");
            stringBuilder.append("and");
            stringBuilder.append(" ");
            stringBuilder.append("password =");
            stringBuilder.append(" ");
            stringBuilder.append("?");
            PreparedStatement preparedStatement = cnn.prepareStatement(stringBuilder.toString());
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee.setName(resultSet.getString(1));
                employee.setAddress(resultSet.getString(2));
                employee.setEmail(resultSet.getString(3));
            } else {
                return null;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return employee;
    }
}
