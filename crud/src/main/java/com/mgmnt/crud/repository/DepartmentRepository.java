package com.mgmnt.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgmnt.crud.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}