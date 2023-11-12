package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Peliculas;

public interface IPeliculasService {
	public List<Peliculas> listarPeliculas(); //Listar ALL
	public Peliculas guardarPeliculas(Peliculas peliculas); //Guardar
	public Peliculas peliculasXID (Long id); //Leer datos de un cliente READ
	public Peliculas actualizarPeliculas(Peliculas peliculas); //UPDATE
	public void eliminarPeliculas (Long id); //DELETE
}
