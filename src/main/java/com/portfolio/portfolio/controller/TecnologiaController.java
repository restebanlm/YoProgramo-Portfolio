package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Tecnologia;
import com.portfolio.portfolio.service.PersonaService;
import com.portfolio.portfolio.service.TecnologiaService;
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
@RequestMapping("/api/portfolio/tecnologia/")
public class TecnologiaController {
    
    @Autowired
    private TecnologiaService tecnologiaService;
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/getall")
    public List<Tecnologia> getTecnologias(){
        return tecnologiaService.getTecnologias();
    }
    
    @GetMapping("/get/{id_persona}")
    public List<Tecnologia> getTecnologiasPersona(@PathVariable Long id_persona){
        return tecnologiaService.getTecnologiasPersona(id_persona);
    }
    
    @PostMapping("/create/{id_persona}")
    @ResponseStatus(HttpStatus.OK)
    public String createTecnologia(@PathVariable Long id_persona,
                                @RequestBody Tecnologia tecnologia){
        
        tecnologia.setPersona(personaService.findPersona(id_persona));
        
        tecnologiaService.saveTecnologia(tecnologia);
        
        // Devuelve un string avisando si creó correctamente.
        return "Tecnología almacenada correctamente.";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteTecnologia (@PathVariable Long id){
        tecnologiaService.deleteTecnologia(id);
        
        // Devuelve un string avisando si eliminó correctamente.
        return "Tecnología eliminada correctamente.";
    }
    
    @PutMapping("/edit/{id_tecnologia}")
    public Tecnologia editTecnologia (
                                    @PathVariable Long id_tecnologia,
                                    @RequestParam ("titulo") String titulo,
                                    @RequestParam ("porcentaje") Integer porcentaje) {
        
        Tecnologia tecnologia = tecnologiaService.findTecnologia(id_tecnologia);

  
        if(!(tecnologia == null)){
            tecnologia.setTitulo(titulo);
            tecnologia.setPorcentaje(porcentaje);
            
            tecnologiaService.saveTecnologia(tecnologia);
        }
        
        //Devuelve la tecnología.
        return tecnologia;
    }
}