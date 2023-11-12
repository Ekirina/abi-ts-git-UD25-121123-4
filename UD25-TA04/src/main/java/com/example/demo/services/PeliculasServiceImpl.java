package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPeliculasDAO;
import com.example.demo.dto.Peliculas;

@Service
public class PeliculasServiceImpl implements IPeliculasService{
	
	@Autowired
	IPeliculasDAO iPeliculasDAO;
	
	@Override
	public List<Peliculas> listarPeliculas() {
		return iPeliculasDAO.findAll();

	}

	@Override
	public Peliculas guardarPeliculas(Peliculas peliculas) {
		return  iPeliculasDAO.save(peliculas);
	}

	@Override
	public Peliculas peliculasXID(Long id) {
		return iPeliculasDAO.findById(id).get();

	}

	@Override
	public Peliculas actualizarPeliculas(Peliculas peliculas) {
		return iPeliculasDAO.save(peliculas);

	}

	@Override
	public void eliminarPeliculas(Long id) {
		iPeliculasDAO.deleteById(id);		
		
	}

}
