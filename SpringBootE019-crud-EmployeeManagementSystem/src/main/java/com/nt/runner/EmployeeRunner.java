package com.nt.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.service.EmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	private final EmployeeService service;

	EmployeeRunner(EmployeeService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
			System.out.println("1. Add Single Employee");
			System.out.println("2. Add Multiple Employees");
			System.out.println("3. View Employee By Id");
			System.out.println("4. View All Employees");
			System.out.println("5. Check Employee Exists");
			System.out.println("6. Count Employees");
			System.out.println("7. Update Employee");
			System.out.println("8. Delete Employee By Id");
			System.out.println("9. Delete Employee");
			System.out.println("10. Delete Multiple Employees");
			System.out.println("11. Delete All Employees");
			System.out.println("12. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			// Add Single Employee
			case 1 -> {

				Employee emp = new Employee();

				emp.setEmployeeName(IO.readln("Enter Employee Name : "));
				emp.setDepartment(IO.readln("Enter Department : "));
				emp.setSalary(Double.parseDouble(IO.readln("Enter Salary : ")));

				System.out.println(service.addSingleEmployee(emp));

			}

			// Add Multiple Employees
			case 2 -> {

				Employee e1 = new Employee();
				e1.setEmployeeName(IO.readln("Enter Employee1 Name : "));
				e1.setDepartment(IO.readln("Enter Employee1 Department : "));
				e1.setSalary(Double.parseDouble(IO.readln("Enter Employee1 Salary : ")));

				Employee e2 = new Employee();
				e2.setEmployeeName(IO.readln("Enter Employee2 Name : "));
				e2.setDepartment(IO.readln("Enter Employee2 Department : "));
				e2.setSalary(Double.parseDouble(IO.readln("Enter Employee2 Salary : ")));

				service.addMultipleEmployees(Arrays.asList(e1, e2));

				System.out.println("Multiple Employees Saved Successfully");

			}

			// View Employee By Id
			case 3 ->

			{
				Long id = Long.parseLong(IO.readln("Enter Employee Id : "));

				Optional<Employee> employee = service.getEmployeeById(id);

				if (employee != null) {
					IO.println(employee);
				}

				else {
					IO.println("Employee Not Found");
				}

			}

			// View All Employees
			case 4 -> {

				Iterable<Employee> employees = service.getAllEmployees();

				employees.forEach(System.out::println);

			}

			// Check Employee Exists
			case 5 -> {

				Long checkId = Long.parseLong(IO.readln("Enter Employee Id : "));
				System.out.println(service.isEmployeeExists(checkId));

			}

			// Count Employees
			case 6 -> {

				System.out.println("Total Employees : " + service.getEmployeesCount());

			}

			// Update Employee
			case 7 -> {

				Long updateId = Long.parseLong(IO.readln("Enter Employee Id : "));

				Employee updateEmp = new Employee();

				updateEmp.setDepartment(IO.readln("Enter New Department : "));
				updateEmp.setDepartment(IO.readln("Enter New Department : "));
				updateEmp.setSalary(Double.parseDouble(IO.readln("Enter New Salary : ")));

				Employee updated = service.updateEmployee(updateId, updateEmp);

				if (updated != null) {
					IO.println("Employee Updated Successfully");
				} else {
					IO.println("Employee Not Found");
				}

			}

			// Delete Employee By Id
			case 8 -> {

				Long deleteId = Long.parseLong(IO.readln("Enter Employee Id : "));

				service.deleteEmployeeById(deleteId);

			}

			// Delete Employee Object
			case 9 -> {

				Long empId = Long.parseLong(IO.readln("Enter Employee Id : "));

				Optional<Employee> deleteEmp = service.getEmployeeById(empId);

				if (deleteEmp.isPresent()) {
					service.deleteEmployee(deleteEmp.get());
				} else {
					System.out.println("Employee Not Found");
				}

			}

			// Delete Multiple Employees
			case 10 -> {

				Long id1 = Long.parseLong(IO.readln("Enter First Employee Id : "));

				Long id2 = Long.parseLong(IO.readln("Enter Second Employee Id : "));

				Optional<Employee> emp1 = service.getEmployeeById(id1);

				Optional<Employee> emp2 = service.getEmployeeById(id2);

				if (emp1.isPresent() && emp2.isPresent()) {
					service.deleteMultipleEmployees(Arrays.asList(emp1.get(), emp2.get()));
				} else {
					System.out.println("One or Both Employees Not Found");
				}

			}

			// Delete All Employees
			case 11 -> service.deleteAllEmployees();
			
			// Exit
			case 12 -> {
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}
}