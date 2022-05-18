package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.ExperienciaLaboral;
import com.portfolio.portfolio.service.ExperienciaLaboralService;
import com.portfolio.portfolio.service.PersonaService;
import com.portfolio.portfolio.service.ProvinciaService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/portfolio/experiencia/")
public class ExperienciaLaboralController {
    
    @Autowired
    private ExperienciaLaboralService experienciaLaboralService;
    
    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private ProvinciaService provinciaService;
    
    
    @GetMapping("/getall")
    public List<ExperienciaLaboral> getExperienciasLaborales(){
        return experienciaLaboralService.getExperienciasLaborales();
    }
    
    @GetMapping("/get/{id_persona}")
    public List<ExperienciaLaboral> getExperienciasLaboralesPersona(@PathVariable Long id_persona){
        return experienciaLaboralService.getExperienciasLaboralesPersona(id_persona);
    }
    
    @PostMapping("/create/{id_persona}/{id_provincia}")
    @ResponseStatus(HttpStatus.OK)
    public String createExperienciaLaboral(@PathVariable Long id_persona,
                                            @PathVariable Long id_provincia,
                                            @RequestBody ExperienciaLaboral experienciaLaboral){
        
        experienciaLaboral.setPersona(personaService.findPersona(id_persona));
        experienciaLaboral.setProvincia(provinciaService.findProvincia(id_provincia));
        
        experienciaLaboralService.saveExperienciaLaboral(experienciaLaboral);
        
        // Devuelve un string avisando si creó correctamente.
        return "Experiencia Laboral almacenada correctamente.";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteExperienciaLaboral (@PathVariable Long id){
        experienciaLaboralService.deleteExperienciaLaboral(id);
        
        // Devuelve un string avisando si eliminó correctamente.
        return "Experiencia Laboral eliminada correctamente.";
    }
    
    @PutMapping("/edit/{id_experiencia_laboral}/{id_provincia}")
    public ExperienciaLaboral editExperienciaLaboral (
                                    @PathVariable Long id_experiencia_laboral,
                                    @PathVariable Long id_provincia,
                                    @RequestBody ExperienciaLaboral explab) {
        
        ExperienciaLaboral experienciaLaboral = experienciaLaboralService.findExperienciaLaboral(id_experiencia_laboral);
        
        if(experienciaLaboral != null){
            experienciaLaboral.setDescripcion(explab.getDescripcion());
            experienciaLaboral.setEs_activo(explab.isEs_activo());
            experienciaLaboral.setFecha_fin(explab.getFecha_fin());
            experienciaLaboral.setFecha_inicio(explab.getFecha_inicio());
            experienciaLaboral.setJornada_laboral(explab.getJornada_laboral());
            experienciaLaboral.setOrganizacion(explab.getOrganizacion());
            experienciaLaboral.setProvincia(provinciaService.findProvincia(id_provincia));
            experienciaLaboral.setTitulo(explab.getTitulo());
            
            experienciaLaboralService.saveExperienciaLaboral(experienciaLaboral);
        }
        
        //Devuelve la experiencia.
        return experienciaLaboral;
    }
}