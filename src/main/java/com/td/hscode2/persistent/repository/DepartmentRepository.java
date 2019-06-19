package com.td.hscode2.persistent.repository;


import com.td.hscode2.persistent.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
