package com.example.demo.api.service;

import java.util.List;

import com.example.demo.api.repository.modelo.Vehiculo;
import com.example.demo.api.service.to.VehiculoTO;

public interface IVehiculoService {
	
	public void guardar(Vehiculo vehiculo);
	
	public List<Vehiculo> buscarTodos();
	
	public VehiculoTO convertir (Vehiculo vehiculo);
	
	public void borrar (Vehiculo vehiculo);
	
	public Vehiculo buscarPorPlacas (String placa);

}
