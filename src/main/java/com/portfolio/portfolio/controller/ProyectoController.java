package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Proyecto;
import com.portfolio.portfolio.service.PersonaService;
import com.portfolio.portfolio.service.ProyectoService;
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
@RequestMapping("/api/portfolio/proyecto/")
public class ProyectoController {
    
    @Autowired
    private ProyectoService proyectoService;
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/getall")
    public List<Proyecto> getProyectos(){
        return proyectoService.getProyectos();
    }
    
    @GetMapping("/get/{id_persona}")
    public List<Proyecto> getProyectosPersona(@PathVariable Long id_persona){
        return proyectoService.getProyectosPersona(id_persona);
    }
    
    @PostMapping("/create/{id_persona}")
    @ResponseStatus(HttpStatus.OK)
    public String createProyecto(@PathVariable Long id_persona,
                                @RequestBody Proyecto proyecto){
        
        proyecto.setPersona(personaService.findPersona(id_persona));
        
        proyectoService.saveProyecto(proyecto);
        
        // Devuelve un string avisando si creó correctamente.
        return "Proyecto almacenado correctamente.";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteProyecto (@PathVariable Long id){
        proyectoService.deleteProyecto(id);
        
        // Devuelve un string avisando si eliminó correctamente.
        return "Proyecto eliminado correctamente.";
    }
    
    @PutMapping("/edit/{id_proyecto}")
    public Proyecto editProyecto (
                                    @PathVariable Long id_proyecto,
                                    @RequestParam ("nombre") String nombre,
                                    @RequestParam ("fecha_inicio") Date fecha_inicio,
                                    @RequestParam ("fecha_fin") Date fecha_fin,
                                    @RequestParam ("es_activo") boolean es_activo,
                                    @RequestParam ("descripcion") String descripcion,
                                    @RequestParam ("imagen") String imagen) {
        
        Proyecto proyecto = proyectoService.findProyecto(id_proyecto);
        
        if(!(proyecto == null)){
            proyecto.setNombre(nombre);
            proyecto.setFecha_inicio(fecha_inicio);
            proyecto.setFecha_fin(fecha_fin);
            proyecto.setEs_activo(es_activo);
            proyecto.setDescripcion(descripcion);
            proyecto.setImagen(imagen);
            
            proyectoService.saveProyecto(proyecto);
        }
        
        //Devuelve el proyecto.
        return proyecto;
    }
}