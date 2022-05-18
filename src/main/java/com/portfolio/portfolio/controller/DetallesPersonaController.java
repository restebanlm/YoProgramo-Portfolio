package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.DetallesPersona;
import com.portfolio.portfolio.service.DetallesPersonaService;
import com.portfolio.portfolio.service.DireccionService;
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
@RequestMapping("/api/portfolio/detallespersona/")
public class DetallesPersonaController {
    
    @Autowired
    private DetallesPersonaService detallesPersonaService;
    
    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private DireccionService direccionService;
    
    @GetMapping("/getall")
    public List<DetallesPersona> getDetallesPersonas(){
        return detallesPersonaService.getDetallesPersonas();
    }
    
    @GetMapping("/get/{id_persona}")
    public DetallesPersona getDetallesPersona(@PathVariable Long id_persona){
        return detallesPersonaService.getDetallesPersona(id_persona);
    }
    
    @PostMapping("/create/{id_persona}/{id_direccion}")
    @ResponseStatus(HttpStatus.OK)
    public String createDetallesPersona(@PathVariable Long id_persona,
                                        @PathVariable Long id_direccion,
                                        @RequestBody DetallesPersona detallesPersona){
        
        detallesPersona.setPersona(personaService.findPersona(id_persona));
        detallesPersona.setDireccion(direccionService.findDireccion(id_direccion));
        detallesPersonaService.saveDetallesPersona(detallesPersona);
        
        // Devuelve un string avisando si creó correctamente.
        return "Detalles almacenados correctamente.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDetallesPersona (@PathVariable Long id){
        detallesPersonaService.deleteDetallesPersona(id);
        
        // Devuelve un string avisando si eliminó correctamente.
        return "Detalles eliminados correctamente.";
    }
    @PutMapping("/edit/{id_persona}/{id_direccion}")
    public DetallesPersona editDetallesPersona (@PathVariable Long id_persona,
                                                @PathVariable Long id_direccion,
                                                @RequestParam ("correo_electronico") String correo_electronico,
                                                @RequestParam ("direccion_github") String direccion_github,
                                                @RequestParam ("direccion_instragram") String direccion_instragram,
                                                @RequestParam ("direccion_twitter") String direccion_twitter,
                                                @RequestParam ("direccion_facebook") String direccion_facebook,
                                                @RequestParam ("foto_perfil") String foto_perfil,
                                                @RequestParam ("foto_portada") String foto_portada,
                                                @RequestParam ("titulo_presentacion") String titulo_presentacion,
                                                @RequestParam ("sobre_mi") String sobre_mi) {
        
        DetallesPersona detallesPersona = detallesPersonaService.getDetallesPersona(id_persona);
  
        if(!(detallesPersona == null)){
            detallesPersona.setCorreo_electronico(correo_electronico);
            detallesPersona.setDireccion_github(direccion_github);
            detallesPersona.setDireccion_instragram(direccion_instragram);
            detallesPersona.setDireccion_twitter(direccion_twitter);
            detallesPersona.setDireccion_facebook(direccion_facebook);
            detallesPersona.setFoto_perfil(foto_perfil);
            detallesPersona.setFoto_portada(foto_portada);
            detallesPersona.setTitulo_presentacion(titulo_presentacion);
            detallesPersona.setSobre_mi(sobre_mi);

            detallesPersonaService.saveDetallesPersona(detallesPersona);
        }
        
        //Devuelve el detalle de la persona.
        return detallesPersona;
    }
}