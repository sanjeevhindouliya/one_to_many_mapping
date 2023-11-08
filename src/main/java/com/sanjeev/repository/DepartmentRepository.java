package com.sanjeev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeev.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
