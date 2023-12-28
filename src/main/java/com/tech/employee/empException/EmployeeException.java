package com.tech.employee.empException;

import java.util.NoSuchElementException;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tech.employee.empcustomException.SalaryNotFoundException;

@RestControllerAdvice
public class EmployeeException {
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> namenotfound(NameNotFoundException n){
		return new ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Agebelow21Exception.class)
	public ResponseEntity<Object> agebelow21(Agebelow21Exception a){
		return new ResponseEntity<>(a.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(GendernotfoundException.class)
	public ResponseEntity<Object> gendernotfound(GendernotfoundException g){
		return new ResponseEntity<>(g.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> nosuchelement(NoSuchElementException no){
		return new ResponseEntity<>(no.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object> gendernotfound(SalaryNotFoundException g){
		return new ResponseEntity<>(g.getMessage(),HttpStatus.NOT_FOUND);
	}
}















