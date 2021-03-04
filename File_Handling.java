package com.employee.payroll;

import java.util.Scanner;

import java.util.LinkedList;

public class EmployeePayrollService {

	public static void main(String args[]) {
		LinkedList<EmployeeData> Store = new LinkedList<EmployeeData>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Employee Id");
		int id;
		id = sc.nextInt();
		System.out.println("Enter The Employee Name");
		String name;
		name = sc.next();
		System.out.println("Enter The Employee Salary");
		Double salary = sc.nextDouble();
		EmployeeData obj = new EmployeeData(id, name, salary);
		Store.add(obj);
		System.out.println(Store);
	}
}

class EmployeeData {
	private int id;
	private String name;
	private Double salary;

	public String toString() {

		return "EmployeeData[ID:" + id + " NAME :" + name + " SALARY:" + salary + "]";

	}

	EmployeeData(int id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
