package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepo;

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
		IO.println("All Employee Removed");		
	}


	// findAll(Pageable pageable) method is used to retrieve employees page by page
	// PageRequest.of(pageNumber, pageSize) creates pagination object
	// pageNumber -> page to be displayed, pageSize -> number of records per page
	@Override
	public Page<Employee> getEmployeesByPage(int pageNumber, int pageSize) 
	{
		//PageRequest page = PageRequest.of(pageNumber, pageSize);
	//	return eRepo.findAll(page);
		 return eRepo.findAll(PageRequest.of(pageNumber, pageSize));
	}


	// findAll(Sort sort) method is used to retrieve employees sorted by salary
	// flag = true  -> Ascending Order, flag = false -> Descending Order
	@Override
	public List<Employee> getEmployeesSortedBySalary(boolean flag, String salary) 
	{
		Sort sal = Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, salary);
		return (List<Employee>) eRepo.findAll(sal);
	}


	// findAll(Sort sort) method is used to retrieve employees sorted by name
	// flag = true  -> Ascending Order, flag = false -> Descending Order
	@Override
	public List<Employee> getEmployeesSortedByName(boolean flag, String employeeName) 
	{
		Sort nam = Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, employeeName);
		return (List<Employee>) eRepo.findAll(nam);
	}
}