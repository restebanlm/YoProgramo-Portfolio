package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Educacion;
import com.portfolio.portfolio.repository.EducacionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public List<Educacion> getEstudios() {
        return educacionRepository.findAll();
    }

    @Override
    public List<Educacion> getEstudiosPersona(Long idPersona) {
        List<Educacion> listaEstudios = new ArrayList<>();
        
        List<Educacion> listaEstudiosTodos = educacionRepository.findAll();
        
        for(Educacion e : listaEstudiosTodos){
            if(Objects.equals(e.getPersona().getId(), idPersona)){
                listaEstudios.add(e);
            }
        }
        return listaEstudios;
    }

    @Override
    public void saveEstudio(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    @Override
    public void deleteEstudio(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEstudio(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }
}