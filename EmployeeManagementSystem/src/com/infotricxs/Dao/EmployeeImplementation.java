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

	public void addEmployee(Employee employee) {
		employees.add(employee);
		dataAccess.saveAllEmployees(employees);
		System.out.println("Employee added successfully!");

	}

	public void viewAllEmployees() throws EmployeeException {
		if (employees.isEmpty() || employees == null) {
//            System.out.println("No employees found.");
			throw new EmployeeException("No employees found.");
		} else {
			for (Employee employee : employees) {
				System.out.println(employee);
				System.out.println("-----------------------------------------------------------------------------");

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
			System.out.println("Employee with ID " + id + " deleted successfully!");
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
				employee.setDesignation(updatedEmployee.getDesignation());
				found = true;
				break;
			}
		}
		if (found) {
			dataAccess.saveAllEmployees(employees);
			System.out.println("Employee with ID " + id + " updated successfully!");
		} else {
			throw new EmployeeException("Employee not found with ID: " + id);
		}
	}
}
