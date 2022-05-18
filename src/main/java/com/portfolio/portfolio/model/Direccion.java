package com.portfolio.portfolio.model;

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
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descripcion;
    @JoinColumn(name ="provincia_id",unique =false)
    @OneToOne(cascade = CascadeType.ALL)
    private Provincia provincia;
}
