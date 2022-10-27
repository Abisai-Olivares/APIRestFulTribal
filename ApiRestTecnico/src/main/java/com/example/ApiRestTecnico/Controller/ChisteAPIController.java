package com.example.ApiRestTecnico.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiRestTecnico.Service.ChisteAPIService;

@RestController
public class ChisteAPIController {
	
	private final ChisteAPIService chisteAPIService;
	
	@Autowired
	public ChisteAPIController (ChisteAPIService chisteAPIService) {
		this.chisteAPIService=chisteAPIService;
	}
	
	
	@GetMapping("/chiste")
	public ResponseEntity<?>getMensaje(){
		return chisteAPIService.getMensaje();
	}

}
