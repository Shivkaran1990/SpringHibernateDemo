package com.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.entity.EmployeeEntity;
import com.interfaces.EmployeeDAO;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{
	@Autowired
    private SessionFactory sessionFactory;
    public void addEmployee(EmployeeEntity employee) {
        this.sessionFactory.getCurrentSession().save(employee);
    }
    @SuppressWarnings("unchecked")
    public List<EmployeeEntity> getAllEmployees() {
        return this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity").list();
    }
    public void deleteEmployee(Integer employeeId) {
        EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(
                EmployeeEntity.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
    }
	public void updateEmployee(Integer employeeId, EmployeeEntity employeeEntity) {
		this.sessionFactory.getCurrentSession().update(Integer.toString(employeeId), employeeEntity);
	}

}
