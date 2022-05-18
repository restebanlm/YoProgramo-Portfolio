package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Usuario;
import com.portfolio.portfolio.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/portfolio/usuario/")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public String createUsuario(@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario);
        
        // Devuelve un string avisando si creó correctamente.
        return "Usuario creado correctamente.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsuario (@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        
        // Devuelve un string avisando si eliminó correctamente.
        return "Usuario eliminado correctamente.";
    }
    
    @PutMapping("/edit/{id}")
    public Usuario editUsuario (@PathVariable Long id,
                                @RequestParam ("nombre_usuario") String nombreUsuario,
                                @RequestParam ("password") String password){
        // Busco la persona en cuestion.
        Usuario usuario = usuarioService.findUsuario(id);
        
        // Esto puede ir tambien en el service.
        usuario.setNombre_usuario(nombreUsuario);
        usuario.setPassword(password);
        
        usuarioService.saveUsuario(usuario);
        
        //Devolvemos a la persona.
        return usuario;
    }
}
