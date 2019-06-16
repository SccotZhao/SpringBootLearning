package com.scott.bootjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.scott.bootjpa.model.Alien;


//JpaRepository will have more feature
//format the response in json
public interface AlienRepo extends JpaRepository<Alien, Integer>{

	List<Alien> findByTech(String tech);
	
	
	//The name should start with findBy and plus the information
	List<Alien> findByAidGreaterThan(int adi);
	
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String tech);
}
