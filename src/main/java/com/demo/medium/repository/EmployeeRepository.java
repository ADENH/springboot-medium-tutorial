package com.demo.medium.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.medium.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByIsDelete(Integer isDelete);
	Optional<Employee> findByIdNumber(Integer idNumber);
}
