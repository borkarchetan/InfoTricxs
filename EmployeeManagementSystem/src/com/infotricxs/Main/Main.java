package com.infotricxs.Main;

import java.util.Scanner;

import com.infotricxs.Dao.EmployeeImplementation;
import com.infotricxs.Exception.EmployeeException;
import com.infotricxs.Model.Employee;

public class Main {

	public static void main(String[] args) throws EmployeeException {
		Scanner scanner = new Scanner(System.in);
		EmployeeImplementation managementSystem = new EmployeeImplementation("employees.txt");

		while (true) {
			System.out.println();
			System.out.println("========== Employee Management System ==========" + "\n");
			System.out.println("1. Add Employee" + "\n");
			System.out.println("2. View All Employees" + "\n");
			System.out.println("3. Delete Employee" + "\n");
			System.out.println("4. Update Employee Details" + "\n");
			System.out.println("5. Exit" + "\n");
			System.out.print("Enter your choice: " + "\n");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter Employee ID: ");
				int id = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter Employee Name: ");
				String name = scanner.nextLine();

				System.out.print("Enter Employee Age: ");
				int age = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter Employee Address: ");
				String address = scanner.nextLine();

				System.out.print("Enter Employee Salary: ");
				double salary = scanner.nextDouble();
				scanner.nextLine();

				System.out.print("Enter Employee Designation: ");
				String designation = scanner.nextLine();

				Employee employee = new Employee(id, name, age, address, salary, designation);
				managementSystem.addEmployee(employee);
				break;
			case 2:
				managementSystem.viewAllEmployees();
				break;
			case 3:
				System.out.print("Enter Employee ID to delete: ");
				int deleteId = scanner.nextInt();
				scanner.nextLine();
				managementSystem.deleteEmployee(deleteId);
				break;
			case 4:
				System.out.print("Enter Employee ID to update: ");
				int updateId = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter new Employee Name: ");
				String newName = scanner.nextLine();

				System.out.print("Enter new Employee Age: ");
				int newAge = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter new Employee Address: ");
				String newAddress = scanner.nextLine();

				System.out.print("Enter new Employee Salary: ");
				double newSalary = scanner.nextDouble();
				scanner.nextLine();

				System.out.print("Enter new Employee Designation: ");
				String newDesignation = scanner.nextLine();

				Employee updatedEmployee = new Employee(updateId, newName, newAge, newAddress, newSalary,
						newDesignation);
				managementSystem.updateEmployeeDetails(updateId, updatedEmployee);
				break;
			case 5:
				System.out.println("Thank you for using the Employee Management System!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
}
