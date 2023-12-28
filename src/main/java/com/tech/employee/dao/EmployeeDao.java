package com.tech.employee.dao;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tech.employee.Repositary.EmployeeRepositary;
import com.tech.employee.entity.Employee;

@Repository

public class EmployeeDao {
	@Autowired
	EmployeeRepositary empRepo;
	public String addEmp(Employee e) {
		empRepo.save(e);
		return "Successfully Saved";
	}
	public String addEmp(List<Employee> e1) {
		empRepo.saveAll(e1);
		return "Successfully Saved";
	}
	public Employee findid(int id) {
		empRepo.findById(id);
		return empRepo.findById(id).get();
	}
	public List<Employee> findemp() {
		return empRepo.findAll();
	}
	public String updateemp(Employee e2) {
		empRepo.save(e2);
		return "Updated";
	}
	public List<Employee> getbybetweensalary(int sal1,int sal2){
		List<Employee> empsal= empRepo.getbybetweensalary(sal1, sal2);
		return empsal;
		
	}
	public List<String> getnamebyage(){
		return empRepo.getnamebyage();
	}
	public List<Employee> getempbyage(){
		return empRepo.getempbyage();
	}
	public List<Integer> getagefromemp(){
		return empRepo.getagefromemp(); 
	}
	public List<Employee> getempnameasc(){
		return empRepo.getempnameasc();
	}
	public List<Object> getnameage() {
		return empRepo.getnameage();
	}
	public Object getnameageone(int id) {
		return empRepo.getnameageone(id);
	}
	public String addEmp1(Employee e) {
		empRepo.save(e);
		return "Employee age is more than 21"; 
	}
	public Employee findEmpid(int id) {
		return empRepo.findById(id).get();
	}
	public Employee getEmpbyid(int id) {
		return empRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Invalid id"));
	}
	public Employee getEmpage(int age) {
		return empRepo.getEmpage(age);
	}
}
