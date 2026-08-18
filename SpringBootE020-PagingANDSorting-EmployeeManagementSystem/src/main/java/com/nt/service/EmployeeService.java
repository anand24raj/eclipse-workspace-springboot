package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nt.entity.Employee;

public interface EmployeeService {

	// 1. Add Single Employee
	// CrudRepository method:  <S extends T> S save(S entity);
	// Meaning: It saves one employee record into the database.
	Employee addSingleEmployee(Employee emp);


	// 2. Add Multiple Employees
	// CrudRepository method: <S extends T> Iterable<S> saveAll(Iterable<S> entities);
	// Meaning: It saves multiple employee records into the database.
	Iterable<Employee> addMultipleEmployees(Iterable<Employee> emp);


	// 3. View Employee By Id
	// CrudRepository method: Optional<T> findById(ID id);
	// Meaning: It searches employee record by employeeId.
	Optional<Employee> getEmployeeById(Long id);


	// 4. View All Employees
	// CrudRepository method: Iterable<T> findAll();
	// Meaning:It returns all employee records from the database.
	Iterable<Employee> getAllEmployees();


	// 5. Check Employee Exists
	// CrudRepository method: boolean existsById(ID id);
	// Meaning: It checks whether employee exists or not by employeeId.
	boolean isEmployeeExists(Long id);


	// 6. Count Total Employees
	// CrudRepository method: long count();
	// Meaning: It returns total number of employee records.
	long getEmployeesCount();


	// 7. Update Employee Details
	// CrudRepository method: <S extends T> S save(S entity);
	// Meaning: It updates employee details if employeeId already exists.
	Employee updateEmployee(Long id, Employee emp);


	// 8. Delete Employee By Id
	// CrudRepository method: void deleteById(ID id);
	// Meaning: It deletes employee record using employeeId.
	void deleteEmployeeById(Long id);


	// 9. Delete Employee Record
	// CrudRepository method: void delete(T entity);
	// Meaning: It deletes a given employee object from database.
	void deleteEmployee(Employee emp);


	// 10. Delete Multiple Employees
	// CrudRepository method: void deleteAll(Iterable<? extends T> entities);
	// Meaning: It deletes multiple employee records from database.
	void deleteMultipleEmployees(Iterable<Employee> emp);


	// 11. Delete All Employees
	// CrudRepository method: void deleteAll();
	// Meaning: It deletes all employee records from database.
	void deleteAllEmployees();


	// 12. View Employees with Pagination
	// PagingAndSortingRepository / JpaRepository method: Page<T> findAll(Pageable pageable);
	// Meaning: It displays employee records page by page.pageSize means how many records you want on one page.
	Page<Employee> getEmployeesByPage(int pageNumber, int pageSize);


	// 13. View Employees Sorted by Salary
	// PagingAndSortingRepository / JpaRepository method: Iterable<T> findAll(Sort sort);
	// Meaning: It displays all employee records sorted by salary.
	// flag true means ascending order. flag false means descending order.
	List<Employee> getEmployeesSortedBySalary(boolean flag, String salary);


	// 14. View Employees Sorted by Name
	// PagingAndSortingRepository / JpaRepository method: Iterable<T> findAll(Sort sort);
	// Meaning: It displays all employee records sorted by name.
	// flag true means ascending order. flag false means descending order.
	// name means the field name used for sorting.
	List<Employee> getEmployeesSortedByName(boolean flag, String name);

}