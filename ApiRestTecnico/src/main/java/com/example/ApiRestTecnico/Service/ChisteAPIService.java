package com.example.ApiRestTecnico.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ApiRestTecnico.Dao.ChisteAPIDao;

@Service
public class ChisteAPIService {
	
	@Autowired
	private final ChisteAPIDao chisteAPIDao;
	
	public ChisteAPIService (ChisteAPIDao chisteAPIDao) {
		this.chisteAPIDao=chisteAPIDao;
	}
	
	public ResponseEntity<?> getMensaje(){
		return chisteAPIDao.getMensaje();
		
	}

}
