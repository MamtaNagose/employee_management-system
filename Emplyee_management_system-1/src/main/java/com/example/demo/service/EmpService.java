package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepo;


@Service
public class EmpService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmpService.class);	
	
	@Autowired
	private EmpRepo repo;

	public void addEmp(Employee e) {
		try {
			repo.save(e);
		}catch(DataIntegrityViolationException exp) {
        	//exp.printStackTrace();
			System.out.println("not exit");
		}
		catch(Exception exp) {
        	//exp.printStackTrace();
			System.out.println("this name already exist");
		}
		
		
		
	}

	public List<Employee> getAllEmp() {
		return repo.findAll();
	}

	public Employee getEMpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEMp(int id) {
		repo.deleteById(id);
	}

	

}