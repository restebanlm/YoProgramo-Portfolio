package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Provincia;
import com.portfolio.portfolio.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService implements IProvinciaService{
    
    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<Provincia> getProvincias() {
        return provinciaRepository.findAll();
    }

    @Override
    public void saveProvincia(Provincia provincia) {
        provinciaRepository.save(provincia);
    }

    @Override
    public void deleteProvincia(Long id) {
        provinciaRepository.deleteById(id);
    }

    @Override
    public Provincia findProvincia(Long id) {
        return provinciaRepository.findById(id).orElse(null);
    }
    
}
