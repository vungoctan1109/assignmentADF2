package controller;

import entity.Employee;
import model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {
    private Scanner scanner = new Scanner(System.in);
    private EmployeeModel employeeModel = new EmployeeModel();

    public void signUp() {
        Employee employee = new Employee();
        while (true) {
            System.out.println("Please enter your username: ");
            String username = scanner.nextLine();
            employee.setUsername(username);
            if (employeeModel.checkExistAccount(username)) {
                System.err.println("Your account is already existed. Please try again.");
            } else {
                System.out.println("Please enter your password: ");
                String password = scanner.nextLine();
                employee.setPassword(password);
                System.out.println("Please enter your name: ");
                String name = scanner.nextLine();
                employee.setName(name);
                System.out.println("Please enter your email: ");
                String email = scanner.nextLine();
                employee.setEmail(email);
                System.out.println("Please enter your address: ");
                String address = scanner.nextLine();
                employee.setAddress(address);
                employeeModel.register(employee);
                System.out.println("Action success!");
            }
            break;
        }
    }

    public void login() {
        while (true) {
            System.out.println("Please enter your username: ");
            String username = scanner.nextLine();
            System.out.println("Please enter your password: ");
            String password = scanner.nextLine();
            Employee employee = employeeModel.login(username, password);
            if (employee == null) {
                System.err.println("Your username or password is incorrect.Please try again.");
            } else {
                System.out.println("Login success!");
                System.out.println(employee.showInfo());
            }
            break;
        }
    }
}
