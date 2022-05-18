package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Direccion;
import java.util.List;

public interface IDireccionService {
    public List<Direccion> getDirecciones(); // Método para traer a todas las direcciones.
    public void saveDireccion (Direccion direccion); // Método para dar de alta a una dirección.
    public void deleteDireccion (Long id); // Método para borrar a una dirección.
    public Direccion findDireccion (Long id); // Método para encontrar una dirección.
}
