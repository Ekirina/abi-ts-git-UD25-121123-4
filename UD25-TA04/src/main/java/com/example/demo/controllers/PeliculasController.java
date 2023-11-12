package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Peliculas;
import com.example.demo.services.PeliculasServiceImpl;

@RestController
@RequestMapping("/api")
public class PeliculasController {
	@Autowired
	PeliculasServiceImpl peliculasServiceImpl;
	
	@GetMapping("/peliculas")
	public List<Peliculas> listarPeliculas(){
		return peliculasServiceImpl.listarPeliculas();
	}
	
	@PostMapping("/peliculas")
	public Peliculas salvarPeliculas(@RequestBody Peliculas peliculas) {
		return peliculasServiceImpl.guardarPeliculas(peliculas);
	}
	@GetMapping("/peliculas/{id}")
	public Peliculas peliculasXID(@PathVariable(name="id")Long id) {
		Peliculas peliculas_xid = new Peliculas();
		peliculas_xid = peliculasServiceImpl.peliculasXID(id);
		System.out.println("Peliculas XID: "+peliculas_xid);
		return peliculas_xid;
	}
	@PutMapping("/peliculas/{id}")
	public Peliculas actualizarPeliculas(@PathVariable(name="id")Long id, @RequestBody Peliculas peliculas) {
		Peliculas peliculas_seleccionado = new Peliculas();
		Peliculas peliculas_actualizado = new Peliculas();
		
		peliculas_seleccionado = peliculasServiceImpl.peliculasXID(id);
		
		peliculas_seleccionado.setNombre(peliculas.getNombre());
		peliculas_seleccionado.setCalificacion_edad(peliculas.getCalificacion_edad());
		
		peliculas_actualizado = peliculasServiceImpl.actualizarPeliculas(peliculas_seleccionado);
		System.out.println("La película actualizada es: "+peliculas_actualizado);
		
		return peliculas_actualizado;
	}
	@DeleteMapping("/peliculas/{id}")
	public void eliminarPeliculas (@PathVariable(name="id")Long id) {
		peliculasServiceImpl.eliminarPeliculas(id);
	}
	
}

