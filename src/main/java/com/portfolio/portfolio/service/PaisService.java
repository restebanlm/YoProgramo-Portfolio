package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Pais;
import com.portfolio.portfolio.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService implements IPaisService{
    
    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> getPaises() {
        return paisRepository.findAll();
    }

    @Override
    public void savePais(Pais pais) {
        paisRepository.save(pais);
    }

    @Override
    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }

    @Override
    public Pais findPais(Long id) {
        return paisRepository.findById(id).orElse(null);
    }
    
}
