package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Tecnologia;
import java.util.List;

public interface ITecnologiaService {
    public List<Tecnologia> getTecnologias(); // Método para traer a todos los registros de tecnología.
    public List<Tecnologia> getTecnologiasPersona(Long idPersona); // Método para traer todos los registros de tecnología de una persona.
    public void saveTecnologia (Tecnologia tecnologia); // Método para dar de alta a una tecnología.
    public void deleteTecnologia (Long id); // Método para borrar una tecnología.
    public Tecnologia findTecnologia (Long id); // Método para encontrar una tecnología.
}
