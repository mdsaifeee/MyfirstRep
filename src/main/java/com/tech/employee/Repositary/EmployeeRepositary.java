package com.tech.employee.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.tech.employee.entity.Employee;

public interface EmployeeRepositary extends JpaRepository<Employee, Integer> {
	@Query(value = "select * from employee where salary>=? and salary<=?", nativeQuery = true)
	public List<Employee> getbybetweensalary(int sal1, int sal2);

	@Query(value = "select name from employee where age<=26", nativeQuery = true)
	public List<String> getnamebyage();

	@Query(value = "select * from Employee where age>=27", nativeQuery = true)
	public List<Employee> getempbyage();

	@Query(value = "select age from employee", nativeQuery = true)
	public List<Integer> getagefromemp();

	@Query(value = "select * from employee order by name asc", nativeQuery = true)
	public List<Employee> getempnameasc();

	@Query(value = "select name,age from employee", nativeQuery = true)
	public List<Object> getnameage();

	@Query(value = "select name,age from employee where id=?", nativeQuery = true)
	public Object getnameageone(int id);
	
	@Query(value="select e from Employee e where e.age=:age")
	public Employee getEmpage(@Param ("age") int age);
}
