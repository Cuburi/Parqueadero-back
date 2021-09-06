package com.example.demoparqueadero.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String placa;
	
	@Column
	private String fechaLlegada;
	
	@Column
	private String horaLlegada;
	
	
	public Vehiculo() {
		SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterHour = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		this.fechaLlegada = formatterDate.format(date);
		this.horaLlegada = formatterHour.format(date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}	
	
}
