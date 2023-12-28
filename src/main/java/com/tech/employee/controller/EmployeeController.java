package com.tech.employee.controller;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tech.employee.empException.Agebelow21Exception;
import com.tech.employee.empException.GendernotfoundException;
import com.tech.employee.empcustomException.SalaryNotFoundException;
import com.tech.employee.entity.Employee;
import com.tech.employee.service.EmployeeService;

@RestController
@RequestMapping("/empcon")

public class EmployeeController {
	@Autowired
	EmployeeService empser;

	@PostMapping(value = "/insert")
	public String addEmp(@RequestBody Employee e) {
		return empser.addEmp(e);
	}

	@PostMapping(value = "/insert1")
	public String addEmp(@RequestBody List<Employee> e1) {
		return empser.addEmp(e1);
	}

	@GetMapping(value = "/insert2/{id}")
	public Employee findid(@PathVariable int id) {
		return empser.findid(id);
	}

	@GetMapping(value = "/insert3")
	public List<Employee> findemp() {
		return empser.findemp();
	}

	@PutMapping(value = "/insert4")
	public String updateemp(@RequestBody Employee e2) {
		return empser.updateemp(e2);
	}

	@GetMapping(value = "/getbyname/{name}")
	public List<Employee> getempbyname(@PathVariable String name) {
		return empser.getempbyname(name);
	}

	@GetMapping(value = "/getgenderbysalary/{salary}")
	public List<String> getgender(@PathVariable int salary) {
		return empser.getgender(salary);
	}

	@GetMapping(value = "/getsalarybyname/{name}")
	public List<Integer> getsalary(@PathVariable String name) {
		return empser.getsalary(name);
	}

	@GetMapping(value="/getsalarybygender/{gender}")
	public List<Integer> getsalary1(@PathVariable String gender){
		return empser.getsalary1(gender);
	}

	@GetMapping(value="/getnamebygender/{gender}")
	public List<String> getgender1(@PathVariable String gender){
		return empser.getgender1(gender);
	}
	@GetMapping(value="/getmaxsalary")
	public Employee getmaxsal() {
		return empser.getmaxsal();
	}
	@GetMapping(value="/getminsalary")
	public Employee getminsal(Employee emn) {
		return empser.getminsal(emn);
	}
	@GetMapping(value="/getempbybetweensalary/{sal1}/{sal2}")
	public List<Employee> getbybetweensalary(@PathVariable int sal1,@PathVariable int sal2){
		return empser.getbybetweensalary(sal1,sal2);
	}
	@GetMapping(value="/getnamebyage")
	public List<String> getnamebyage(){
		return empser.getnamebyage();
	}
	@GetMapping(value="/getempbyage")
	public List<Employee> getempbyage(){
		return empser.getempbyage();
	}
	@GetMapping(value="/getagefromemployee")
	public List<Integer> getagefromemp(){
		return empser.getagefromemp(); 
	}
	@GetMapping(value="/getempasc")
	public List<Employee> getempnameasc(){
		return empser.getempnameasc();
	}
	@GetMapping(value="/getnameage")
	public List<Object> getnameage() {
		return empser.getnameage();
	}
	@GetMapping(value="/getnameage1/{id}")
	public Object getnameageone(@PathVariable int id) {
		return empser.getnameageone(id);
	}
	@PostMapping(value="/addEmp1")
	public String addEmp1(@RequestBody Employee e) throws Agebelow21Exception {
		return empser.addEmp1(e);
	}
	@GetMapping(value="/getEmpbyName/{name}")
	public List<Employee> getEmpbyName(@PathVariable String name) throws NameNotFoundException {
		return empser.getEmpbyName(name);
	}
	@GetMapping(value="/getEmpbygender/{gender}")
	public List<Employee> getEmpbygender(@PathVariable String gender) throws GendernotfoundException{
		return empser.getEmpbygender(gender);
	}
	@GetMapping(value = "/findEmpid/{id}")
	public Employee findEmpid(@PathVariable int id) {
		return empser.findid(id);
	}
	@GetMapping(value="/empSal1/{sal}")
	public List<Employee> empSal1(@PathVariable int sal) throws SalaryNotFoundException{
		return empser.empSal1(sal);
	}
	@GetMapping(value = "/getEmpbyid/{id}")
	public Employee getEmpbyid(@PathVariable int id) {
		return empser.getEmpbyid(id);
	}
	@GetMapping(value="/getEmpage/{age}")
	public Employee getEmpage(@PathVariable int age) {
		return empser.getEmpage(age);
	}
}
