package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="salas")
public class Salas {
	//Atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca el último valor e incrementa desde la id final de la db
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "codigo_peliculas")
	private Peliculas peliculas;
	
	//Constructores
	public Salas(){
	}
	
	public Salas(Long id, String nombre, Peliculas peliculas) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.peliculas = peliculas;
	}
	//Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Peliculas getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Peliculas peliculas) {
		this.peliculas = peliculas;
	}
	//Método String

	@Override
	public String toString() {
		return "Salas [id=" + id + ", nombre=" + nombre + ", peliculas=" + peliculas + "]";
	}
	
}
