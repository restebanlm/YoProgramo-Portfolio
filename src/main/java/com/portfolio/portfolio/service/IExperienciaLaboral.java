package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboral {
    public List<ExperienciaLaboral> getExperienciasLaborales(); // Método para traer a todos los registros de experiencia laboral.
    public List<ExperienciaLaboral> getExperienciasLaboralesPersona(Long idPersona); // Método para traer todos los registros de experiencia laboral de una persona.
    public void saveExperienciaLaboral (ExperienciaLaboral experienciaLaboral); // Método para dar de alta a una experiencia laboral.
    public void deleteExperienciaLaboral (Long id); // Método para borrar una experiencia laboral.
    public ExperienciaLaboral findExperienciaLaboral (Long id); // Método para encontrar una experiencia laboral.
}