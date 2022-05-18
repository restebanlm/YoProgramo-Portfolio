package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> getUsuarios(); // Método para traer todos los usuarios.
    public void saveUsuario (Usuario usuario); // Método para dar de alta a un usuario.
    public void deleteUsuario (Long id); // Método para borrar a un usuario.
    public Usuario findUsuario (Long id); // Método para encontrar un usuario.
}