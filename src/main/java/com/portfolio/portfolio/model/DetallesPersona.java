package com.portfolio.portfolio.model;

import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class DetallesPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    @JoinColumn(name ="persona_id",unique =true)
    @OneToOne(cascade = CascadeType.ALL)
    private Persona persona;
    private String correo_electronico;
    private String direccion_github;
    private String direccion_instragram;
    private String direccion_twitter;
    private String direccion_facebook;
    private String foto_perfil;
    private String foto_portada;
    private String titulo_presentacion;
    private String sobre_mi;
    @JoinColumn(name ="direccion_id",unique =false)
    @OneToOne(cascade = CascadeType.ALL)
    private Direccion direccion;
}
