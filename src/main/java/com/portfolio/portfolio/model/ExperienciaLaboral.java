package com.portfolio.portfolio.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @JoinColumn(name ="persona_id",unique =false)
    @ManyToOne
    private Persona persona;
    @JoinColumn(name ="provincia_id",unique =false)
    @ManyToOne
    private Provincia provincia;
    private String organizacion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private boolean es_activo;
    private String descripcion;
    private String titulo;
    private String jornada_laboral;
}