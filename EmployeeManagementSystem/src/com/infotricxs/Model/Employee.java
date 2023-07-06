package com.infotricxs.Model;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String city;
	private double salary;
	private String designation;

	public Employee(int id, String name, int age, String city, double salary, String designation) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
		this.salary = salary;
		this.designation = designation;
	}

	// Getters and setters

	// Override toString() method for easy printing of employee details
	@Override
	public String toString() {
		return "Employee ID: " + id + "\nName: " + name + "\nAge: " + age + "\nCity: " + city + "\nSalary: " + salary
				+ "\nDesignation: " + designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
