package co.edu.unicundi.proyectoSpringPrueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//cerrar sesion
@RestController
@RequestMapping("/cerrarSesion")
public class TokenController {

	@Autowired
	private ConsumerTokenServices service;
	
	
	@GetMapping("/anular/{tokenId:.*}")
	public void anularToken(@PathVariable("tokenId") String token) {
		service.revokeToken(token);
	}
		
}