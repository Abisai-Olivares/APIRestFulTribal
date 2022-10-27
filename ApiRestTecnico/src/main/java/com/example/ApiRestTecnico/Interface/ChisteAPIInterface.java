package com.example.ApiRestTecnico.Interface;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ChisteAPIInterface {
	ResponseEntity<?> getMensaje();

}
