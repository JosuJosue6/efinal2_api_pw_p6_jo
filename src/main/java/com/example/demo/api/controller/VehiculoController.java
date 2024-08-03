package com.example.demo.api.controller;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.repository.modelo.Vehiculo;
import com.example.demo.api.service.IVehiculoService;
import com.example.demo.api.service.to.VehiculoTO;

@CrossOrigin
@RestController
@RequestMapping(path = "/vehiculos")
public class VehiculoController {

	@Autowired
	private IVehiculoService service;

	// http://localhost:8082/API/v1.0/Consecionario/vehiculos
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@RequestBody Vehiculo vehiculo) {
		this.service.guardar(vehiculo);
	}

	// http://localhost:8082/API/v1.0/Consecionario/vehiculos
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VehiculoTO> buscarTodos() {
		List<VehiculoTO> ls = new ArrayList<>();
		List<Vehiculo> lsV = this.service.buscarTodos();

		for (Vehiculo vehiculo : lsV) {
			ls.add(this.service.convertir(vehiculo));
		}
		return ls;
	}

	// http://localhost:8082/API/v1.0/Consecionario/vehiculos
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@RequestBody Vehiculo vehiculo) {
		this.service.borrar(vehiculo);
	}

	// http://localhost:8082/API/v1.0/Consecionario/vehiculos
	@GetMapping(path = "/{placa}",produces = MediaType.APPLICATION_JSON_VALUE)
	public VehiculoTO buscarPorPlaca(@PathVariable String placa) {
		
		return this.service.convertir(this.service.buscarPorPlacas(placa));
	}

}
