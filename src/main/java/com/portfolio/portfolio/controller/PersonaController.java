package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Persona;
import com.portfolio.portfolio.model.Usuario;
import com.portfolio.portfolio.service.PersonaService;
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
@RequestMapping("/api/portfolio/persona/")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public String createUsuario(@RequestBody Persona persona){
        personaService.savePersona(persona);
        
        // Devuelve un string avisando si creó correctamente.
        return "Persona creada correctamente.";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePersona (@PathVariable Long id){
        personaService.deletePersona(id);
        
        // Devuelve un string avisando si eliminó correctamente.
        return "Persona eliminada correctamente.";
    }
    
    @PutMapping("/edit/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam ("nombre") String nombre,
                                @RequestParam ("apellido") String apellido,
                                @RequestParam ("nombre_usuario") String nombreUsuario,
                                @RequestParam ("password") String password){
        // Busco la persona en cuestion.
        Persona persona = personaService.findPersona(id);
        
        Usuario usuario = persona.getUsuario();
        
        usuario.setNombre_usuario(nombreUsuario);
        usuario.setPassword(password);
        
        // Esto puede ir tambien en el service.
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setUsuario(usuario);
        persona.setUsuario(usuario);
        
        personaService.savePersona(persona);
        
        //Devolvemos a la persona.
        return persona;
    }
}
