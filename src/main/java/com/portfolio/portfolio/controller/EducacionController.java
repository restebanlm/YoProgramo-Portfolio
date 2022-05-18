package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Educacion;
import com.portfolio.portfolio.service.EducacionService;
import com.portfolio.portfolio.service.PersonaService;
import java.util.Date;
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
@RequestMapping("/api/portfolio/educacion/")
public class EducacionController {
    
    @Autowired
    private EducacionService educacionService;
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/getall")
    public List<Educacion> getEstudios(){
        return educacionService.getEstudios();
    }
    
    @GetMapping("/get/{id_persona}")
    public List<Educacion> getEstudiosPersona(@PathVariable Long id_persona){
        return educacionService.getEstudiosPersona(id_persona);
    }
    

    @PostMapping("/create/{id_persona}")
    @ResponseStatus(HttpStatus.OK)
    public String createEstudio(@PathVariable Long id_persona,
                                @RequestBody Educacion educacion){
        
        educacion.setPersona(personaService.findPersona(id_persona));
        
        educacionService.saveEstudio(educacion);
        
        // Devuelve un string avisando si creó correctamente.
        return "Estudio almacenado correctamente.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEstudio (@PathVariable Long id){
        educacionService.deleteEstudio(id);
        
        // Devuelve un string avisando si eliminó correctamente.
        return "Estudio eliminado correctamente.";
    }
    
    @PutMapping("/edit/{id_educacion}")
    public Educacion editEstudio (
                                    @PathVariable Long id_educacion,
                                    @RequestParam ("titulo") String titulo,
                                    @RequestParam ("organizacion") String organizacion,
                                    @RequestParam ("fecha_inicio") Date fecha_inicio,
                                    @RequestParam ("fecha_fin") Date fecha_fin,
                                    @RequestParam ("es_activo") boolean es_activo,
                                    @RequestParam ("promedio") float promedio) {
        
        Educacion educacion = educacionService.findEstudio(id_educacion);
  
        if(!(educacion == null)){
            educacion.setTitulo(titulo);
            educacion.setOrganizacion(organizacion);
            educacion.setFecha_inicio(fecha_inicio);
            educacion.setFecha_fin(fecha_fin);
            educacion.setEs_activo(es_activo);
            educacion.setPromedio(promedio);
            
            educacionService.saveEstudio(educacion);
        }
        
        // Devuelve el estudio almacenado.
        return educacion;
    }
}