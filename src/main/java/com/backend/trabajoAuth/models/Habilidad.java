package com.backend.trabajoAuth.models;

import jakarta.persistence.*;

@Entity
@Table(name = "habilidades")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "incremento_atk")
    private Integer incrementoAtk;
    @Column(name = "incremento_def")
    private Integer incrementoDef;
    @Column(name = "incremento_sp")
    private Integer incrementoSp;

    @ManyToOne
    @JoinColumn(name = "personaje")
    private Personaje personaje;

    public Habilidad() {}

    public Habilidad(String nombre, String descripcion, Integer incrementoAtk, Integer incrementoDef, Integer incrementoSp, Personaje personaje) {
        this.nombre = nombre;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.incrementoAtk = incrementoAtk;
        this.incrementoDef = incrementoDef;
        this.incrementoSp = incrementoSp;
        this.personaje = personaje;
    }

    public Habilidad(String nombre, String descripcion, Integer incrementoAtk, Integer incrementoDef, Integer incrementoSp) {
        this.nombre = nombre;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.incrementoAtk = incrementoAtk;
        this.incrementoDef = incrementoDef;
        this.incrementoSp = incrementoSp;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getIncrementoAtk() { return incrementoAtk; }
    public int getIncrementoDef() { return incrementoDef; }
    public int getSp() { return incrementoSp; }
    public Personaje getPersonaje() { return personaje; }
    public void setPersonaje(Personaje personaje) {this.personaje = personaje;}

    @Override
    public String toString() {
        return String.format(
                "Habilidad[id=%d, nombre='%s', descripcion='%s', incrementoAtk='%d', incrementoDef='%d', incrementoSp='%d']",
                id, nombre, descripcion, incrementoAtk, incrementoDef, incrementoSp);
    }

}
