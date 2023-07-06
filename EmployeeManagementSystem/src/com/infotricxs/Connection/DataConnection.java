package com.infotricxs.Connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.infotricxs.Model.Employee;

public class DataConnection {

	private String filePath = "D:\\InfoTricxs\\EmployeeManagementSystem\\src\\employees.txt";

	public DataConnection(String filePath) {
		this.filePath = filePath;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] employeeData = line.split(",");
				int id = Integer.parseInt(employeeData[0]);
				String name = employeeData[1];
				int age = Integer.parseInt(employeeData[2]);
				String address = employeeData[3];
				double salary = Double.parseDouble(employeeData[4]);
				String designation = employeeData[5];

				Employee employee = new Employee(id, name, age, address, salary, designation);
				employees.add(employee);
			}
		} catch (IOException e) {
			System.out.println("An error occurred while retrieving employee data from the file.");
			e.printStackTrace();
		}

		return employees;
	}

	public void saveAllEmployees(List<Employee> employees) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			for (Employee employee : employees) {
				writer.println(employeeToFormattedString(employee));
			}
			System.out.println("Employee data saved successfully!");
		} catch (IOException e) {
			System.out.println("An error occurred while saving employee data to the file.");
			e.printStackTrace();
		}
	}

	private String employeeToFormattedString(Employee employee) {
		return employee.getId() + "," + employee.getName() + "," + employee.getAge() + "," + employee.getCity() + ","
				+ employee.getSalary() + "," + employee.getDesignation();
	}

}
