package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> getEstudios(); // Método para traer a todos los registros de educación.
    public List<Educacion> getEstudiosPersona(Long idPersona); // Método para traer todos los registros de educación de una persona.
    public void saveEstudio (Educacion educacion); // Método para dar de alta a una educación.
    public void deleteEstudio (Long id); // Método para borrar una educación.
    public Educacion findEstudio (Long id); // Método para encontrar una educación.
}
