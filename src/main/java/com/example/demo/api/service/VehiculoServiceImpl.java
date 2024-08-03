package com.example.demo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.repository.IVehiculoRepository;
import com.example.demo.api.repository.modelo.Vehiculo;
import com.example.demo.api.service.to.VehiculoTO;


@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoRepository repository;

	@Override
	public void guardar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.repository.insertar(vehiculo);
	}

	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.repository.buscarTodos();
	}

	@Override
	public VehiculoTO convertir(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		VehiculoTO v = new VehiculoTO();
		v.setColor(vehiculo.getColor());
		v.setMarca(vehiculo.getMarca());
		v.setModelo(vehiculo.getModelo());
		v.setPlaca(vehiculo.getPlaca());
		v.setPrecio(vehiculo.getPrecio());
		return v;
	}

	@Override
	public void borrar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.repository.eliminarPorPlaca(vehiculo.getPlaca());
	}

	@Override
	public Vehiculo buscarPorPlacas(String placa) {
		// TODO Auto-generated method stub
		return this.repository.buscarPorPlaca(placa);
	}
	
	

}
