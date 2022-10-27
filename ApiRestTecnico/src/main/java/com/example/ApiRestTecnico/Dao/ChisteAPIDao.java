package com.example.ApiRestTecnico.Dao;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.ApiRestTecnico.Entity.Chiste;
import com.example.ApiRestTecnico.Interface.ChisteAPIInterface;

@Component
public class ChisteAPIDao implements ChisteAPIInterface {
	
	private final  RestTemplate restTemplate;
	private final String url= "https://api.chucknorris.io/jokes/random";
	
	
	@Autowired
	public ChisteAPIDao (RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
		
	}
	
	private HttpEntity<?> getHttpHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Aplication");
		headers.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_JSON));
		return new HttpEntity<>(headers);
		
	}
	
	
	@Override
	public ResponseEntity<?> getMensaje(){
		try {
			
			ArrayList<Chiste> chistes = new ArrayList();
			
			for(int i=0; i<25; i++) {
				Chiste chisteResponse = restTemplate.exchange(url, HttpMethod.GET,getHttpHeaders(),Chiste.class).getBody();
				if(chistes.contains(chisteResponse)) {
					i--;
				}else {
					chistes.add(chisteResponse);
				}
				
			}
			
			
			assert chistes !=null;
			return responseResult("success", chistes, HttpStatus.OK);
			
		}catch(Error x){
			
			return responseResult("error","Ocurrio un problema"+x,HttpStatus.BAD_REQUEST);
			
		}
	}
	
	
	public ResponseEntity<?> responseResult(String value,Object object,HttpStatus httpStatus){
		Map<String,Object> response = new HashMap<>();
		switch(value) {
		case"success":
			response.put("status", true);
			response.put("datos", object);
			break;
		case "error":
			response.put("status", false);
			response.put("mensaje", object);
			break;
		}
		return new ResponseEntity<>(response,httpStatus);
	}
	

}






