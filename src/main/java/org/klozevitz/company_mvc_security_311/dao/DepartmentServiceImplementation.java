package org.klozevitz.company_mvc_security_311.dao;

import lombok.RequiredArgsConstructor;
import org.klozevitz.company_mvc_security_311.model.Department;
import org.klozevitz.company_mvc_security_311.repositories.DepartmentRepository;
import org.klozevitz.company_mvc_security_311.repositories.ProfessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImplementation implements DepartmentService {

    private final DepartmentRepository repo;

    @Override
    public Department save(Department department) {
        return null;
    }

    @Override
    public List<Department> all() {
        return repo.findAll();
    }

    @Override
    public Optional<Department> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Department update(Department department) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
