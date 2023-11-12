package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="peliculas")
public class Peliculas {
	//Atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca último valor e incrementa desde la id final del db
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "calificacion_edad")
	private String calificacion_edad;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List <Salas> salas;

	//Constructores
	public Peliculas() {

	}

	public Peliculas(Long id, String nombre, String calificacion_edad) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.calificacion_edad = calificacion_edad;
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

	public String getCalificacion_edad() {
		return calificacion_edad;
	}

	public void setCalificacion_edad(String calificacion_edad) {
		this.calificacion_edad = calificacion_edad;
	}
	//return Salas
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "Salas")
	public List<Salas> getSalas() {
		return salas;
	}

	public void setSalas(List<Salas> salas) {
		this.salas = salas;
	}
	//Método de impresión de datos por consola

	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", nombre=" + nombre + ", calificacion_edad=" + calificacion_edad + "]";
	}
	
	
}
