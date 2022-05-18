package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.DetallesPersona;
import java.util.List;

public interface IDetallesPersonaService {
    public List<DetallesPersona> getDetallesPersonas(); // Método para traer a todos los detalles de personas.
    public DetallesPersona getDetallesPersona(Long idPersona); // Método para traer los detalles de una persona.
    public void saveDetallesPersona (DetallesPersona detallesPersona); // Método para dar de alta a un los detalles de un persona.
    public void deleteDetallesPersona (Long id); // Método para borrar los detalles de una persona.
    public DetallesPersona findDetallesPersona (Long id); // Método para encontrar los detalles de una persona.
}
