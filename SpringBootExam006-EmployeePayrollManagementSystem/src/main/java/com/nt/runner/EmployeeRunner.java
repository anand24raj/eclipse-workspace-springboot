package com.nt.runner;

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

            IO.println("\n===== EMPLOYEE PAYROLL MANAGEMENT SYSTEM =====");
            IO.println("1. Register Employee");
            IO.println("2. Search Employee By Id");
            IO.println("3. View All Employees");
            IO.println("4. Update Employee");
            IO.println("5. Delete Employee By Id");
            IO.println("6. Exit");

            int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

            switch (choice) {

            case 1 -> {
                Employee emp = new Employee();

                emp.setEmployeeName(IO.readln("Enter Employee Name : "));
                emp.setDepartment(IO.readln("Enter Department : "));
                emp.setDesignation(IO.readln("Enter Designation : "));
                emp.setBasicSalary(Double.parseDouble(IO.readln("Enter Basic Salary : ")));
                emp.setBonus(Double.parseDouble(IO.readln("Enter Bonus : ")));
                emp.setExperience(Double.parseDouble(IO.readln("Enter Experience : ")));

                Employee saved = service.addEmployee(emp);

                IO.println("Employee Registered Successfully");
                IO.println(saved);
            }

            case 2 -> {
                Long id = Long.parseLong(IO.readln("Enter Employee Id : "));

                Optional<Employee> emp = service.searchEmployee(id);

                if (emp.isPresent()) {
                    IO.println(emp.get());
                } else {
                    IO.println("Employee Not Found");
                }
            }

            case 3 -> {
                Iterable<Employee> employees = service.viewAll();

                employees.forEach(IO::println);
            }

            case 4 -> {
                Long id = Long.parseLong(IO.readln("Enter Employee Id : "));

                Employee updateEmp = new Employee();

                updateEmp.setDesignation(IO.readln("Enter New Designation : "));
                updateEmp.setBasicSalary(Double.parseDouble(IO.readln("Enter New Basic Salary : ")));
                updateEmp.setBonus(Double.parseDouble(IO.readln("Enter New Bonus : ")));

                try {
                    Employee updated = service.updateDetail(id, updateEmp);

                    IO.println("Employee Updated Successfully");
                    IO.println(updated);

                } catch (RuntimeException e) {
                    IO.println("Employee Not Found");
                }
            }

            case 5 -> {
                Long id = Long.parseLong(IO.readln("Enter Employee Id : "));

                service.deleteEmployee(id);
            }

            case 6 -> {
                IO.println("Application Closed Successfully");
                System.exit(0);
            }

            default -> IO.println("Invalid Choice");
            }
        }
    }
}