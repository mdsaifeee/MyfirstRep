package com.tech.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tech.employee.dao.EmployeeDao;
import com.tech.employee.empException.Agebelow21Exception;
import com.tech.employee.empException.GendernotfoundException;
import com.tech.employee.empcustomException.SalaryNotFoundException;
import com.tech.employee.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmp(Employee e) {
		return empDao.addEmp(e);
	}

	public String addEmp(List<Employee> e1) {
		return empDao.addEmp(e1);
	}

	public Employee findid(int id) {
		return empDao.findid(id);
	}

	public List<Employee> findemp() {
		return empDao.findemp();
	}

	public String updateemp(Employee e2) {
		return empDao.updateemp(e2);
	}

	public List<Employee> getempbyname(String name) {
		List<Employee> empall = findemp();
		return empall.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
	}

	public List<String> getgender(int salary) {
		List<Employee> empall = findemp();
		return empall.stream().filter(x -> x.getSalary() == salary).map(x -> x.getGender())
				.collect(Collectors.toList());
	}

	public List<Integer> getsalary(String name) {
		List<Employee> empall = findemp();
		return empall.stream().filter(x -> x.getName().equals(name)).map(x -> x.getSalary())
				.collect(Collectors.toList());
	}

	public List<Integer> getsalary1(String gender) {
		List<Employee> empall = findemp();
		return empall.stream().filter(x -> x.getGender().equals(gender)).map(x -> x.getSalary())
				.collect(Collectors.toList());
	}

	public List<String> getgender1(String gender) {
		List<Employee> empall = findemp();
		return empall.stream().filter(x -> x.getGender().equals(gender)).map(x -> x.getName()).toList();
	}

	public Employee getmaxsal() {
		List<Employee> empall = findemp();
		return empall.stream().max(Comparator.comparing(Employee::getSalary)).get();
	}

	public Employee getminsal(Employee emn) {
		List<Employee> empall = findemp();
		return empall.stream().min(Comparator.comparing(Employee::getSalary)).get();
	}

	public List<Employee> getbybetweensalary(int sal1, int sal2) {
		return empDao.getbybetweensalary(sal1, sal2);
	}

	public List<String> getnamebyage() {
		return empDao.getnamebyage();
	}

	public List<Employee> getempbyage() {
		return empDao.getempbyage();
	}

	public List<Integer> getagefromemp() {
		return empDao.getagefromemp();
	}

	public List<Employee> getempnameasc() {
		return empDao.getempnameasc();
	}

	public List<Object> getnameage() {
		return empDao.getnameage();
	}

	public Object getnameageone(int id) {
		return empDao.getnameageone(id);
	}

	public String addEmp1(Employee e) throws Agebelow21Exception {
		if (e.getAge() >= 21) {
			return empDao.addEmp1(e);
		} else {
			throw new Agebelow21Exception("Employee age is below Requirement");
		}
	}

	public List<Employee> getEmpbyName(String name) throws NameNotFoundException {
		List<Employee> empall = findemp();
		List<Employee> emp1 = empall.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
		if (emp1.isEmpty()) {
			throw new NameNotFoundException("No Such Name Exist");
		} else {
			return emp1;
		}
	}

	public List<Employee> getEmpbygender(String gender) throws GendernotfoundException {
		List<Employee> empall = findemp();
		List<Employee> empgd=empall.stream().filter(x -> x.getGender().equals(gender)).collect(Collectors.toList());
		if(empgd.isEmpty()) {
			throw new GendernotfoundException("Only Male Employees Are here");
		}
		else {
			return empgd;
		}
	}
	public List<Employee> empSal1(int sal) throws SalaryNotFoundException{
		List<Employee> empall = findemp();
		List<Employee> empgd=empall.stream().filter(x -> x.getSalary()==(sal)).collect(Collectors.toList());
		if(empgd.isEmpty()) {
			throw new SalaryNotFoundException("no Employee with that salary");
		}
		else {
			return empgd;
		}
	}

	public Employee findEmpid(int id) {
		return empDao.findid(id);
	}
	public Employee getEmpbyid(int id) {
		return empDao.getEmpbyid(id);
	}
	public Employee getEmpage(int age) {
		return empDao.getEmpage(age);
	}
}
