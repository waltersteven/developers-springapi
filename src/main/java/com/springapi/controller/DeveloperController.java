package com.springapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springapi.model.Developer;
import com.springapi.dao.DeveloperDAO;

@RestController
@RequestMapping("/api")
public class DeveloperController {

	@Autowired
	DeveloperDAO developerDAO;
	
	@GetMapping("/developers")
	public ResponseEntity<List<Developer>> findAll(){
		return new ResponseEntity<List<Developer>>(developerDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/developer")
	public ResponseEntity<Developer> getOne(@RequestParam(value="id") Long devid){
		Developer dev = developerDAO.getOne(devid);
		
		if(dev == null) return ResponseEntity.badRequest().build();
		
		return new ResponseEntity<Developer>(dev, HttpStatus.OK);
	}
	
	@PostMapping("/developers")
	public ResponseEntity<Developer> save(@Valid @RequestBody Developer dev){
		return new ResponseEntity<Developer>(developerDAO.save(dev), HttpStatus.OK);
	}
	
	@PutMapping("/developer")
	public ResponseEntity<Developer> updateDeveloper(@RequestParam(value="id") Long devid, @Valid @RequestBody Developer dev){
		Developer devi = developerDAO.getOne(devid);
		if(devi == null) return ResponseEntity.notFound().build();
		
		devi.setDesignation(dev.getDesignation());
		devi.setExpertise(dev.getExpertise());
		devi.setAge(dev.getAge());
		devi.setCity(dev.getCity());
		devi.setFullname(dev.getFullname());
		
		Developer devaltered = developerDAO.save(devi);
		return ResponseEntity.ok().body(devaltered);
	}
	
	@DeleteMapping("/developer")
	public ResponseEntity<Developer> delete(@RequestParam(value="id") Long devid){
		Developer devi = developerDAO.getOne(devid);
		if (devi == null) return ResponseEntity.notFound().build();
		
		developerDAO.delete(devi);
		return ResponseEntity.ok().build();
		
	}
	
	
}
