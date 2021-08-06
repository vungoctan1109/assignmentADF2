package util;

import annotation.Table;
import entity.Employee;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
    public static void main(String[] args) {
        try {
            migrateData(Employee.class);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private static void migrateData(Class clazz) throws SQLException {
        Connection cnn = ConnectionHelper.getConnection();

        String tableName = clazz.getSimpleName();
        if (!clazz.isAnnotationPresent(Table.class)) {
            System.err.println("Class is not mapping with database.");
            return;
        }
        Table table = (Table) clazz.getAnnotation(Table.class);
        if (!table.name().isEmpty()) {
            tableName = table.name();
        }
        StringBuilder sqlQueryBuilder = new StringBuilder();
        sqlQueryBuilder.append("CREATE TABLE");
        sqlQueryBuilder.append(" ");
        sqlQueryBuilder.append(tableName);
        sqlQueryBuilder.append(" ");
        sqlQueryBuilder.append("(");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            sqlQueryBuilder.append(field.getName());
            sqlQueryBuilder.append(" ");
            if (field.getType().getSimpleName().equals("int")) {
                sqlQueryBuilder.append("INT");
            } else if (field.getType().getSimpleName().equalsIgnoreCase("String")) {
                sqlQueryBuilder.append("VARCHAR(200)");
            } else if (field.getType().getSimpleName().equalsIgnoreCase("Date")) {
                sqlQueryBuilder.append("DATE");
            }
            sqlQueryBuilder.append(", ");
        }
        sqlQueryBuilder.setLength(sqlQueryBuilder.length() - 2);
        sqlQueryBuilder.append(")");
        PreparedStatement preparedStatement = cnn.prepareStatement(sqlQueryBuilder.toString());
        preparedStatement.execute();
        System.out.println(sqlQueryBuilder.toString());
    }
}

