package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersonas(); // Método para traer a todas las personas.
    public void savePersona (Persona persona); // Método para dar de alta a una persona.
    public void deletePersona (Long id); // Método para borrar a una persona.
    public Persona findPersona (Long id); // Método para encontrar una persona.
}
