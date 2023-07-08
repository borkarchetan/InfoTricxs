package com.infotricxs.Dao;

import java.util.List;

import com.infotricxs.Connection.DataConnection;
import com.infotricxs.Exception.EmployeeException;
import com.infotricxs.Model.Employee;

public class EmployeeImplementation {

	private List<Employee> employees;
	private DataConnection dataAccess;

	public EmployeeImplementation(String filePath) {
		dataAccess = new DataConnection(filePath);
		employees = dataAccess.getAllEmployees();
	}

	public boolean isEmployeeIdExists(int id) {
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				return true; // ID already exists
			}
		}
		return false; // ID does not exist
	}

	public void addEmployee(Employee employee) throws EmployeeException {
		if (isEmployeeIdExists(employee.getId())) {
			throw new EmployeeException("Duplicate ID is not allowed.");
		}

		employees.add(employee);
		dataAccess.saveAllEmployees(employees);
		System.out.println("Employee added successfully!");
	}

	public void viewAllEmployees() throws EmployeeException {
		if (employees == null || employees.isEmpty()) {
			throw new EmployeeException("No Employees Found...");
		} else {
			for (Employee employee : employees) {
				System.out.println("*****************************************");
				System.out.println(employee);
				System.out.println("*****************************************");
			}
		}
	}

	public void deleteEmployee(int id) throws EmployeeException {
		boolean found = false;
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				employees.remove(employee);
				found = true;
				break;
			}
		}
		if (found) {
			dataAccess.saveAllEmployees(employees);
			System.out.println("Employee with ID " + id + " Deleted Successfully...!");
		} else {
			throw new EmployeeException("Employee not found with ID: " + id);
		}
	}

	public void updateEmployeeDetails(int id, Employee updatedEmployee) throws EmployeeException {
		boolean found = false;
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				employee.setName(updatedEmployee.getName());
				employee.setAge(updatedEmployee.getAge());
				employee.setCity(updatedEmployee.getCity());
				employee.setSalary(updatedEmployee.getSalary());
				employee.setPosition(updatedEmployee.getPosition());
				found = true;
				break;
			}
		}
		if (found) {
			dataAccess.saveAllEmployees(employees);
			System.out.println("Employee with ID " + id + " updated successfully...!");
		} else {
			throw new EmployeeException("Employee not found with ID: " + id);
		}
	}
}
