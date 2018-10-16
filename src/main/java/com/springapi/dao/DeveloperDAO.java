package com.springapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapi.model.Developer;
import com.springapi.repository.DeveloperRepository;

@Service
public class DeveloperDAO {
	
	@Autowired
	DeveloperRepository developerRepository;
	
	/* get all developers */
	public List<Developer> findAll(){
		return developerRepository.findAll();
	}
	
	/* get a developer by id */
	public Developer getOne(Long devid) {
		return developerRepository.getOne(devid);
	}
	
	/* save a developer */
	public Developer save(Developer dev) {
		return developerRepository.save(dev);
	}
	
	/* delete an employee */
	public void delete(Developer dev) {
		developerRepository.delete(dev);
	}
}
