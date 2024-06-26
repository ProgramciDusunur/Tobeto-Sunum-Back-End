package com.tobeto.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.employee.AddResponseDTO;
import com.tobeto.dto.employee.DeleteRequestDTO;
import com.tobeto.dto.employee.DeleteResponseDTO;
import com.tobeto.dto.employee.EditAdminPasswordRequestDTO;
import com.tobeto.dto.employee.EditPasswordRequestDTO;
import com.tobeto.dto.employee.EditPasswordResponseDTO;
import com.tobeto.dto.employee.EditRoleRequestDTO;
import com.tobeto.dto.employee.EditRoleResponseDTO;
import com.tobeto.dto.employee.EmployeeDTO;
import com.tobeto.dto.employee.GetRequestDTO;
import com.tobeto.dto.employee.GetResponseDTO;
import com.tobeto.entity.Employee;
import com.tobeto.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping("/add")
	public AddResponseDTO addEmployee(@RequestBody EmployeeDTO dto) {
		Employee employee = requestMapper.map(dto, Employee.class);
		employeeService.createEmployee(employee);
		System.out.println("Add çalisiyor");
		return new AddResponseDTO(employee.getId());

	}

	@GetMapping("/get")
	public GetResponseDTO getEmployee(@RequestBody GetRequestDTO dto) {
		Employee employee = employeeService.readEmployee(dto.getEmail());
		return new GetResponseDTO(employee.getId(), employee.getName(), employee.getPassword(), employee.getEmail(),
				employee.getRole());
	}

	@GetMapping("/get/all")
	public ResponseEntity<String> getAllEmployees() {
		List<Employee> allEmployees = employeeService.getAllEmployees();

		// ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(allEmployees);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@PostMapping("/del")
	public DeleteResponseDTO deleteEmployee(@RequestBody DeleteRequestDTO dto) {
		System.out.println(dto);
		employeeService.deleteEmployee(dto.getEmail());
		return new DeleteResponseDTO("Employee deleted.");
	}

	@PutMapping("/edit/role")
	public EditRoleResponseDTO editRole(@RequestBody EditRoleRequestDTO dto) {
		Employee employee = employeeService.readEmployee(dto.getEmail());
		String previusRole = employee.getRole();
		employee.setRole(dto.getRole());
		employeeService.createEmployee(employee);
		System.out.println("Role.. Calisiyor");
		return new EditRoleResponseDTO(previusRole, dto.getRole(), dto.getEmail(), employee.getName(),
				employee.getSurname());
	}

	@PostMapping("/edit/password")
	public EditPasswordResponseDTO editPassword(@RequestBody EditPasswordRequestDTO dto) {
		Employee employee = employeeService.updatePassword(dto.getEmail(), dto.getPreviousPassword(),
				dto.getNewPassword());
		String message;
		if (dto.getNewPassword().equals(employee.getPassword())) {
			message = "Password succesfully changed!";
		} else {
			message = "Error!";
		}
		return new EditPasswordResponseDTO(dto.getPreviousPassword(), dto.getNewPassword(), dto.getEmail(), message);
	}

	@PostMapping("/edit/password/admin")
	public SuccessResponseDTO editPasswordAdmin(@RequestBody EditAdminPasswordRequestDTO dto) {
		System.out.println("admin şifre değiştirme...");
		employeeService.updatePasswordAdmin(dto.getEmail(), dto.getNewPassword());
		return new SuccessResponseDTO();
	}

}