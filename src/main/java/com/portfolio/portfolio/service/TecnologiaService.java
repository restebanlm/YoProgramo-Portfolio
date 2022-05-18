package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Tecnologia;
import com.portfolio.portfolio.repository.TecnologiaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologiaService{
    
    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Override
    public List<Tecnologia> getTecnologias() {
        return tecnologiaRepository.findAll();
    }

    @Override
    public List<Tecnologia> getTecnologiasPersona(Long idPersona) {
        List<Tecnologia> listaTecnologias = new ArrayList<>();
        
        List<Tecnologia> listaTecnologiasTodos = tecnologiaRepository.findAll();
        
        for(Tecnologia t : listaTecnologiasTodos){
            if(Objects.equals(t.getPersona().getId(), idPersona)){
                listaTecnologias.add(t);
            }
        }
        return listaTecnologias;
    }

    @Override
    public void saveTecnologia(Tecnologia tecnologia) {
        tecnologiaRepository.save(tecnologia);
    }

    @Override
    public void deleteTecnologia(Long id) {
        tecnologiaRepository.deleteById(id);
    }

    @Override
    public Tecnologia findTecnologia(Long id) {
        return tecnologiaRepository.findById(id).orElse(null);
    }
}