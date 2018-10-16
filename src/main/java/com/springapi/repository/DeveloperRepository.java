package com.springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springapi.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long>{

}
