package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Provincia;
import java.util.List;

public interface IProvinciaService {
    public List<Provincia> getProvincias(); // Método para traer a todas provincias.
    public void saveProvincia (Provincia provincia); // Método para dar de alta a una provincia.
    public void deleteProvincia (Long id); // Método para borrar a una provincia.
    public Provincia findProvincia (Long id); // Método para encontrar una provincia.
}
