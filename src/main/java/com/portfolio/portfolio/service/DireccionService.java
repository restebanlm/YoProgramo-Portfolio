package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Direccion;
import com.portfolio.portfolio.repository.DireccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService implements IDireccionService{

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public List<Direccion> getDirecciones() {
        return direccionRepository.findAll();
    }

    @Override
    public void saveDireccion(Direccion direccion) {
        direccionRepository.save(direccion);
    }

    @Override
    public void deleteDireccion(Long id) {
        direccionRepository.deleteById(id);
    }

    @Override
    public Direccion findDireccion(Long id) {
        return direccionRepository.findById(id).orElse(null);
    }
}
