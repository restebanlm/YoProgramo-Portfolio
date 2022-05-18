package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Proyecto;
import com.portfolio.portfolio.repository.ProyectoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository proyectoRepository;
    
    @Override
    public List<Proyecto> getProyectos() {
        return proyectoRepository.findAll();
    }

    @Override
    public List<Proyecto> getProyectosPersona(Long idPersona) {
        List<Proyecto> listaProyectos = new ArrayList<>();
        
        List<Proyecto> listaProyectosTodos = proyectoRepository.findAll();
        
        for(Proyecto t : listaProyectosTodos){
            if(Objects.equals(t.getPersona().getId(), idPersona)){
                listaProyectos.add(t);
            }
        }
        return listaProyectos;
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }
}