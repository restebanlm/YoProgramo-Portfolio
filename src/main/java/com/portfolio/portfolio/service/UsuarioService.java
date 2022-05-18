package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Usuario;
import com.portfolio.portfolio.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuario;
    }
}