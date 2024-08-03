package com.example.demo.api.repository;

import java.util.List;

import com.example.demo.api.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	public void insertar (Vehiculo vehiculo);
	
	public Vehiculo buscarPorPlaca (String placa);
	
	public void actualizar (Vehiculo vehiculo);
	
	public void eliminarPorPlaca (String placa);
	
	
	public List<Vehiculo> buscarTodos();

}
