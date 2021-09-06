package com.example.demoparqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoparqueadero.model.Vehiculo;
import com.example.demoparqueadero.service.api.VehiculoServiceAPI;

@RestController
@RequestMapping(value="/api/v1/")
@CrossOrigin("*")
public class VehiculoRestController {
	
	@Autowired
	private VehiculoServiceAPI vehiculoServiceAPI;
	
	@GetMapping(value = "/all")
	public List<Vehiculo> getAll(){
		return vehiculoServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Vehiculo find(@PathVariable Long id){
		return vehiculoServiceAPI.get(id);
	}
	
	@GetMapping(value = "/findpl/{placa}")
	public Vehiculo find(@PathVariable String placa){
		return vehiculoServiceAPI.getByPlaca(placa);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Vehiculo> save(@RequestBody Vehiculo vehiculo) {
		Vehiculo obj = vehiculoServiceAPI.verifySave(vehiculo);
		return new ResponseEntity<Vehiculo>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "delete/{id}")
	public ResponseEntity<Vehiculo> delete(@PathVariable Long id){
		Vehiculo vehiculo= vehiculoServiceAPI.get(id);
		if (vehiculo != null) {
			vehiculoServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Vehiculo>(vehiculo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Vehiculo>(vehiculo, HttpStatus.OK);
	}
	
	

}
