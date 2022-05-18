package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> getProyectos(); // Método para traer a todos los registros de proyecto.
    public List<Proyecto> getProyectosPersona(Long idPersona); // Método para traer todos los registros de proyecto de una persona.
    public void saveProyecto (Proyecto proyecto); // Método para dar de alta a un proyecto.
    public void deleteProyecto (Long id); // Método para borrar un proyecto.
    public Proyecto findProyecto (Long id); // Método para encontrar un proyecto.
}
