package org.klozevitz.company_mvc_security_311.repositories;

import org.klozevitz.company_mvc_security_311.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
