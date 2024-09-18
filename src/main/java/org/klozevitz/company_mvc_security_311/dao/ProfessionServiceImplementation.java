package org.klozevitz.company_mvc_security_311.dao;

import lombok.RequiredArgsConstructor;
import org.klozevitz.company_mvc_security_311.model.Profession;
import org.klozevitz.company_mvc_security_311.repositories.ProfessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionServiceImplementation implements ProfessionService {
    private final ProfessionRepository repo;

    @Override
    public Profession save(Profession profession) {
        return repo.save(profession);
    }

    @Override
    public List<Profession> all() {
        return repo.findAll();
    }

    @Override
    public Optional<Profession> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Profession update(Profession profession) {
        return save(profession);
    }

    @Override
    public boolean delete(int id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
