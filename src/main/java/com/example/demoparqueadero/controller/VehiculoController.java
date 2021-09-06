package com.example.demoparqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoparqueadero.model.Vehiculo;
import com.example.demoparqueadero.service.api.VehiculoServiceAPI;

@Controller
@RequestMapping
public class VehiculoController {
	
	@Autowired
	private VehiculoServiceAPI vehiculoServiceAPI;
	
	@RequestMapping("/listar")
	public String index(Model model) {
		model.addAttribute("list",vehiculoServiceAPI.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != 0) {
			model.addAttribute("vehiculo",vehiculoServiceAPI.get(id));
		}else {
			model.addAttribute("vehiculo", new Vehiculo());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Vehiculo vehiculo, Model model) {
		vehiculoServiceAPI.save(vehiculo);
		return "redirect:/listar";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		vehiculoServiceAPI.delete(id);
		return "redirect:/listar";
	}
	
}
