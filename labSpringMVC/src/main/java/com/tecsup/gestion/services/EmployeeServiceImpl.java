package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tecsup.gestion.dao.EmployeeDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}

	@Override
	public List<Employee> findAll()
			throws DAOException, EmptyResultException {
		
		List<Employee> emps = employeeDAO.findAllEmployees();
	
		return emps;
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DAOException.class })
	public void createWithRole(String login, String password, String lastname, String firstname, int salary, int dptId,
			String roleId) throws DAOException {

		employeeDAO.create(login, password, lastname, firstname, salary, dptId);
		employeeDAO.addRole(login, roleId);

	}

	
	@Override
	public void update(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException {
	
		employeeDAO.update(login, password, lastname, firstname, salary, dptId);
	}

	@Override
	public void delete(String login) throws DAOException {
		 
		employeeDAO.delete(login);
	
	}

	@Override
	public void create(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException {
	
		employeeDAO.create(login, password, lastname, firstname, salary, dptId);

	}
	
	

}
