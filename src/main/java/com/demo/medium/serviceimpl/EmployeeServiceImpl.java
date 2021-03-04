package com.demo.medium.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.hibernate.UnresolvableObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.medium.config.ConstantUtil;
import com.demo.medium.config.aspect.Compliance;
import com.demo.medium.dto.EmployeeDto;
import com.demo.medium.model.ComplianceAction;
import com.demo.medium.model.entity.Employee;
import com.demo.medium.model.entity.Position;
import com.demo.medium.repository.EmployeeRepository;
import com.demo.medium.repository.PositionRepository;
import com.demo.medium.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	@Compliance(action = ComplianceAction.read)
	public EmployeeDto getEmployeeById(int id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
		return new EmployeeDto(employee);
		
	}

	@Override
	@Compliance(action = ComplianceAction.read)
	public EmployeeDto getEmployeeByIdNumber(int idNumber) {
		Employee employee = employeeRepository.findByIdNumber(idNumber).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
		return new EmployeeDto(employee);
		
	}

	@Override
	@Compliance(action = ComplianceAction.read)
	public List<EmployeeDto> getAllDataEmployee() {
		List<Employee> employees = employeeRepository.findByIsDelete(0);
		return new ArrayList<>(employees.stream()
				 .map(employee -> new EmployeeDto(employee)).collect(Collectors.toList()));
		 
	}

	@Override
	@Compliance(action = ComplianceAction.update)
	public EmployeeDto updateDateEmployee(int idNumber, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.findByIdNumber(idNumber).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
		employee = setEmployeeData(employee, employeeDto);
		employeeRepository.save(employee);
		
		return new EmployeeDto(employee);
	}

	@Override
	@Compliance(action = ComplianceAction.delete)
	public void deleteDataEmployee(int idNumber) {
		Employee employee = employeeRepository.findByIdNumber(idNumber).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
		employee.setIsDelete(1);
		employeeRepository.save(employee);
	}

	@Override
	@Compliance(action = ComplianceAction.create)
	public EmployeeDto saveDateEmployee(EmployeeDto employeeDto) {
		
		Employee employee = new Employee(employeeDto);
		Position position = positionRepository.findByCode(employeeDto.getCodeJabatan()).orElseThrow(() -> new NoSuchElementException("data tidak ditemukan"));
		employee.setPosition(position);
		
		employee = employeeRepository.save(employee);
		if(employee.getId() == null) throw new UnresolvableObjectException(Employee.class,"Gagal Save employee");
		return new EmployeeDto(employee);
	}
	
	private Employee setEmployeeData(Employee employee, EmployeeDto employeeDto) {
		employee.setBirthDate(employeeDto.getBirthDate());
		employee.setGender(employeeDto.getJenisKelamin() == GenderConverter.gender.PRIA ? 1 : 2);
		employee.setIdNumber(employeeDto.getIdNumber());
		employee.setIsDelete(0);
		employee.setName(employeeDto.getName());
		employee.setPosition(positionRepository.findByCode(employeeDto.getCodeJabatan()).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN)));
		return employee;
	}
}
