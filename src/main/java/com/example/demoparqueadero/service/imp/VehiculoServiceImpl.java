package com.example.demoparqueadero.service.imp;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demoparqueadero.commons.GenericServiceImpl;
import com.example.demoparqueadero.dao.api.VehiculoDaoApi;
import com.example.demoparqueadero.model.Vehiculo;
import com.example.demoparqueadero.service.api.VehiculoServiceAPI;

@Service
public class VehiculoServiceImpl extends GenericServiceImpl<Vehiculo, Long> implements VehiculoServiceAPI{
	@Autowired
	private VehiculoDaoApi vehiculoDaoApi;

	@Override
	public CrudRepository<Vehiculo, Long> getDao() {
		return vehiculoDaoApi;
	}
	
	public Vehiculo verifySave(Vehiculo vehiculo) {
		 List<Vehiculo> vehiculos = getAll();
		 int cantidad = getAll().size();
		 if (cantidad < 30) {
			return save(vehiculo);
		}else {
			return null;
		}
	}
	
	public Vehiculo getByPlaca(String placa) {
		List<Vehiculo> vehiculos = getAll();
		for(Vehiculo vehiculo:vehiculos) {
			
			System.out.println(vehiculo.getPlaca());
			System.out.println(placa);
			if(vehiculo.getPlaca().equals(placa)) {
				
				return vehiculo;
			}
		}
		return null;
	}
	
}
