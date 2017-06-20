package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.entity.EmployeeEntity;
import com.interfaces.EmployeeDAO;
import com.interfaces.EmployeeManager;
@Service
public class EmployeeManagerImpl implements EmployeeManager
{
	@Autowired
    private EmployeeDAO employeeDAO;
    @Transactional
    public void addEmployee(EmployeeEntity employee) {
        employeeDAO.addEmployee(employee);
    }
    @Transactional
    public List<EmployeeEntity> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
	public void updateEmployee(Integer employeeId, EmployeeEntity employeeEntity) {
		employeeDAO.updateEmployee(employeeId, employeeEntity);
		
	}
}