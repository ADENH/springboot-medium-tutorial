package com.demo.medium.serviceimpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.hibernate.UnresolvableObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.medium.config.aspect.Compliance;
import com.demo.medium.dto.EmployeeDto;
import com.demo.medium.model.ComplianceAction;
import com.demo.medium.model.Employee;
import com.demo.medium.model.Position;
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
		Employee employee = employeeRepository.findById(id).orElseThrow();
		EmployeeDto employeeDto = new EmployeeDto(employee);
		return employeeDto;
	}

	@Override
	@Compliance(action = ComplianceAction.read)
	public EmployeeDto getEmployeeByIdNumber(int idNumber) {
		Employee employee = employeeRepository.findByIdNumber(idNumber).orElseThrow();
		EmployeeDto employeeDto = new EmployeeDto(employee);
		return employeeDto;
	}

	@Override
	@Compliance(action = ComplianceAction.read)
	public List<EmployeeDto> getAllDataEmployee() {
		List<Employee> employees = employeeRepository.findByIsDelete(0);
		 List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>(employees.stream()
				 .map(employee -> new EmployeeDto(employee)).collect(Collectors.toList()));
		return employeeDtos;
	}

	@Override
	@Compliance(action = ComplianceAction.update)
	public EmployeeDto updateDateEmployee(int idNumber, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.findByIdNumber(idNumber).orElseThrow();
		employee = setEmployeeData(employee, employeeDto);
		employeeRepository.save(employee);
		
		return new EmployeeDto(employee);
	}

	@Override
	@Compliance(action = ComplianceAction.delete)
	public void deleteDataEmployee(int idNumber) {
		Employee employee = employeeRepository.findByIdNumber(idNumber).orElseThrow();
		employee.setIsDelete(1);
		employeeRepository.save(employee);
	}

	@Override
	@Compliance(action = ComplianceAction.create)
	public EmployeeDto saveDateEmployee(EmployeeDto employeeDto) {
		
		Employee employee = new Employee(employeeDto);
		Position position = positionRepository.findByCode(employeeDto.getCodeJabatan()).orElseThrow();
		employee.setPosition(position);
		
		employee = employeeRepository.save(employee);
		if(employee.getId() == null) throw new UnresolvableObjectException(Employee.class,"Gagal Save employee");
		return new EmployeeDto(employee);
	}
	
	private Employee setEmployeeData(Employee employee, EmployeeDto employeeDto) {
		formatDate(employeeDto.getBirthDate());
		employee.setBirthDate(employeeDto.getBirthDate());
		employee.setGender(employeeDto.getJenisKelamin() == GenderConverter.gender.Pria ? 1 : 2);
		employee.setIdNumber(employeeDto.getIdNumber());
		employee.setIsDelete(0);
		employee.setName(employeeDto.getName());
		employee.setPosition(positionRepository.findByCode(employeeDto.getCodeJabatan()).orElseThrow());
		return employee;
	}
	
	private void formatDate(Date datetime) {
//		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
//		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-mm-dd");
//		LocalDate date = LocalDate.parse(datetime.toString(),inputFormatter);
//		String formattedDate = outputFormat.format(date);
//		System.out.println(formattedDate); // prints 10-04-2018
		DateFormat dateFormat = new SimpleDateFormat(
	            "yyyy-mm-dd", Locale.US);
		try {
			dateFormat.parse("Tue Jul 13 00:00:00 CEST 2011");
			System.out.println(dateFormat.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
