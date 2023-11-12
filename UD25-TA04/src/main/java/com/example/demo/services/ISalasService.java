package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Salas;

public interface ISalasService {
	
//Métodos del CRUD
	public List<Salas> listarSalas(); //Listar ALL
	public Salas guardarSalas(Salas salas); //Guardar
	public Salas salasXID (Long id); //Leer datos de un cliente READ
	public Salas actualizarSalas(Salas salas); //UPDATE
	public void eliminarSalas (Long id); //DELETE

}
