package com.mgmnt.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mgmnt.crud.entity.Department;
import com.mgmnt.crud.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private DepartmentRepository departmentRepository;


	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Transactional
	public List<Department> findAllDepartments() {
		return departmentRepository.findAll();
	}
	
	@Transactional
	public Department findDepartmentById(Long id) throws Exception {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new Exception(String.format("Department not found  with ID %d", id)));
	}

	public void saveDepartment(Department department) {
		departmentRepository.save(department);
	}


	public void deleteDepartment(Long id) throws Exception {
		final Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new Exception(String.format("Department not found  with ID %d", id)));

		departmentRepository.deleteById(department.getId());
	}
}
