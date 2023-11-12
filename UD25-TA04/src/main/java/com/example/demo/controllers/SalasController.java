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

import com.example.demo.dto.Salas;
import com.example.demo.services.SalasServiceImpl;

@RestController
@RequestMapping("/api")
public class SalasController {
	@Autowired
	SalasServiceImpl salasServiceImpl;
	@GetMapping("/articulos")
	public List<Salas> listarSalas(){
		return salasServiceImpl.listarSalas();
	}
	
	@PostMapping("/articulos")
	public Salas salvarSalas(@RequestBody Salas articulos) {
		return salasServiceImpl.guardarSalas(articulos);
	}
	@GetMapping("/salas/{id}")
	public Salas salasXID(@PathVariable(name="id")Long id) {
		Salas salas_xid = new Salas();
		salas_xid = salasServiceImpl.salasXID(id);
		System.out.println("Salas XID: "+salas_xid);
		return salas_xid;
	}
	@PutMapping("/salas/{id}")
	public Salas actualizarSalas(@PathVariable(name="id")Long id, @RequestBody Salas salas) {
		Salas salas_seleccionado = new Salas();
		Salas salas_actualizado = new Salas();
		
		salas_seleccionado = salasServiceImpl.salasXID(id);
		
		salas_seleccionado.setNombre(salas.getNombre());
		salas_seleccionado.setPeliculas(salas.getPeliculas());
		
		salas_actualizado = salasServiceImpl.actualizarSalas(salas_seleccionado);
		System.out.println("La sala actualizada es: "+salas_actualizado);
		
		return salas_actualizado;
	}
	@DeleteMapping("/salas/{id}")
	public void eliminarSalas (@PathVariable(name="id")Long id) {
		salasServiceImpl.eliminarSalas(id);
	}
}

