package com.nt.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository eRepo;

	EmployeeServiceImpl(EmployeeRepository eRepo) {
		this.eRepo = eRepo;
	}

    // save() method is used to add single employee
    @Override
    public Employee addSingleEmployee(Employee emp) {
        return eRepo.save(emp);
    }

    // saveAll() method is used to add multiple employees
	@Override
	public Iterable<Employee> addMultipleEmployees(Iterable<Employee> emp) 
	{
		return eRepo.saveAll(emp);
	}

    // findById() method is used to get employee by id
	@Override
	public Optional<Employee> getEmployeeById(Long id) 
	{
      return eRepo.findById(id);
	}
	
    // findAll() method is used to get all employees
    @Override
    public Iterable<Employee> getAllEmployees() {
        return eRepo.findAll();
    }

    // existsById() method is used to check employee exists or not
    @Override
    public boolean isEmployeeExists(Long id) {
        return eRepo.existsById(id);
    }

    // count() method is used to count total employees
    @Override
    public long getEmployeesCount() {
        return eRepo.count();
    }

    //                             Long id, Long newId
    // save() method is also used to update employee details
	@Override
	public Employee updateEmployee(Long id, Employee emp) 
	{
		
	    if (eRepo.existsById(id))
	    	{
	    		emp.setEmployeeId(id); //
	        return eRepo.save(emp);
	    }

	    return null;
	}

	// deleteById() method is used to delete employee by id
	@Override
	public void deleteEmployeeById(Long id) 
	{	
		 if (eRepo.existsById(id)) 
		 {
			eRepo.deleteById(id);
			IO.println("Delete ID Successfully " + id);
		 }
		 IO.println(id + " Not found ");
	}

	// delete() method is used to delete employee object
	@Override
	public void deleteEmployee(Employee emp)
	{	
		 if(eRepo.existsById(emp.getEmployeeId()))
		 {
			eRepo.delete(emp);
			IO.println("Delete Employee Successfully " + emp);
		 }
		 IO.println(emp + "Employee not found");
	}
	
	// deleteAll(Iterable) method is used to delete all employees
	@Override
	public void deleteMultipleEmployees(Iterable<Employee> emp) 
	{
		eRepo.deleteAll(emp);
		IO.println("Multiple Employee Removed..");
	}
	
	// deleteAll() method is used to delete multiple employees
	@Override
	public void deleteAllEmployees() 
	{
		eRepo.deleteAll();
		IO.println("All Employee Removed ");		
	}
}