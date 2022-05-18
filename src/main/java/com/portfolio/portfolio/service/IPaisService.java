package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Pais;
import java.util.List;

public interface IPaisService {
    public List<Pais> getPaises(); // Método para traer a todos los paises.
    public void savePais (Pais pais); // Método para dar de alta a un país.
    public void deletePais (Long id); // Método para borrar a un país.
    public Pais findPais (Long id); // Método para encontrar un país.
}
