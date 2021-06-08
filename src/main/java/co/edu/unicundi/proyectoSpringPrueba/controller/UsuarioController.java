package co.edu.unicundi.proyectoSpringPrueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.proyectoSpringPrueba.service.IUsuarioService;



@RestController
@RequestMapping("/usuarios")
@PreAuthorize("hasAuthority('Administardor')")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	
		

}