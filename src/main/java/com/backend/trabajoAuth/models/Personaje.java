package com.backend.trabajoAuth.models;

import jakarta.persistence.*;

@Entity
@Table(name = "personajes")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "atk")
    private Integer atk;
    @Column(name = "def")
    private Integer def;
    @Column(name = "sp")
    private Integer sp;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Personaje() {}

    public Personaje(String nombre, String tipo, String descripcion, Integer atk, Integer def, Integer sp, Usuario usuario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.atk = atk;
        this.def = def;
        this.sp = sp;
        this.usuario = usuario;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNombre() {return nombre;}
    public String getTipo() {return tipo;}
    public String getDescripcion() {return descripcion;}
    public int getAtk() {return atk;}
    public int getDef() {return def;}
    public int getSp() {return sp;}
    public Usuario getUsuario() {return usuario;}

    @Override
    public String toString() {
        return String.format(
                "Personaje[id=%d, nombre='%s', tipo='%s', descripcion='%s', atk='%d', def='%d', sp='%d']",
                id, nombre, tipo, descripcion, atk, def, sp);
    }

}
