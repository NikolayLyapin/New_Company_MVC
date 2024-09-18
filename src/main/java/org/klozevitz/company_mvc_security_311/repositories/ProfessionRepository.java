package org.klozevitz.company_mvc_security_311.repositories;

import org.klozevitz.company_mvc_security_311.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
