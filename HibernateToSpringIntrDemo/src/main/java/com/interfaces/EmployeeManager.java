package com.interfaces;

import java.util.List;



import com.hibernate.entity.EmployeeEntity;

public interface EmployeeManager {
	public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
    public void updateEmployee(Integer employeeId,EmployeeEntity employeeEntity);
    
    

}
