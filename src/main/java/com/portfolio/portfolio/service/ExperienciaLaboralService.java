package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.ExperienciaLaboral;
import com.portfolio.portfolio.repository.ExperienciaLaboralRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboral{
    
    @Autowired
    private ExperienciaLaboralRepository experienciaLaboralRepository;
    
    @Override
    public List<ExperienciaLaboral> getExperienciasLaborales() {
        return experienciaLaboralRepository.findAll();
    }

    @Override
    public List<ExperienciaLaboral> getExperienciasLaboralesPersona(Long idPersona) {
        List<ExperienciaLaboral> listaExperienciasLaborales = new ArrayList<>();
        
        List<ExperienciaLaboral> listaExperienciasLaboralesTodos = experienciaLaboralRepository.findAll();
        
        for(ExperienciaLaboral el : listaExperienciasLaboralesTodos){
            if(Objects.equals(el.getPersona().getId(), idPersona)){
                listaExperienciasLaborales.add(el);
            }
        }
        return listaExperienciasLaborales;
    }

    @Override
    public void saveExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
        experienciaLaboralRepository.save(experienciaLaboral);
    }

    @Override
    public void deleteExperienciaLaboral(Long id) {
        experienciaLaboralRepository.deleteById(id);
    }

    @Override
    public ExperienciaLaboral findExperienciaLaboral(Long id) {
        return experienciaLaboralRepository.findById(id).orElse(null);
    }
}