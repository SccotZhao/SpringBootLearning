package com.scott.bootjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.scott.bootjpa.model.Alien;

//In this way, we do not need a controller
@RepositoryRestResource(collectionResourceRel="aliens", path="aliens")
public interface AlienRepo extends JpaRepository<Alien, Integer>{

}
