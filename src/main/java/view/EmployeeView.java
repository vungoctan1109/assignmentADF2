package view;

import controller.EmployeeController;

import java.util.Scanner;

public class EmployeeView {
    private EmployeeController employeeController = new EmployeeController();
    Scanner scanner = new Scanner(System.in);

    public void generateEmployeeMenu() {
        while (true) {
            System.out.println("Menu");
            System.out.println("-------------------------------");
            System.out.println("1.Sign up.");
            System.out.println("2.Login.");
            System.out.println("3.Exit.");
            System.out.println("-------------------------------");
            System.out.println("Please enter your choice (0-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    employeeController.signUp();
                    break;
                case 2:
                    employeeController.login();
                    break;
                case 3:
                    System.out.println("Exit program.");
                    break;
                default:
                    break;
            }
            if (choice == 3) {
                break;
            }
            scanner.nextLine();
        }
    }
}
