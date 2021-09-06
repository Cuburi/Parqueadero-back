package com.example.demoparqueadero.service.api;

import com.example.demoparqueadero.commons.GenericServiceAPI;
import com.example.demoparqueadero.model.Vehiculo;

public interface VehiculoServiceAPI extends GenericServiceAPI<Vehiculo, Long>{
	Vehiculo verifySave (Vehiculo vehiculo);
	Vehiculo getByPlaca (String placa);
}
