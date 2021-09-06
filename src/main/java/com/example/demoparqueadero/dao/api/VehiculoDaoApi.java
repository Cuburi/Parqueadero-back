package com.example.demoparqueadero.dao.api;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demoparqueadero.model.Vehiculo;

public interface VehiculoDaoApi extends CrudRepository<Vehiculo, Long> {
}
