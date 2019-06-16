package com.scott.bootjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.scott.bootjpa.dao.AlienRepo;
import com.scott.bootjpa.model.Alien;

//@RestController will repsond body
//so if everything is to respond body, we can just use this one to replace all @responsebody
//@Controller
@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
//	@RequestMapping("/addAlien")
//	public String addAlien(Alien alien) {
//		repo.save(alien);
//		return "home.jsp";
//	}
	
	//If we want also enable to send by raw data, we need the annotation @RequestBody
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien a = repo.getOne(aid);
		
		repo.delete(a);
		return "deleted";
	}
	
//	//the default behavior for requestmapping is GetMapping
//	@RequestMapping("/deleteAlien")
//	public ModelAndView deleteAlien(@RequestParam int aid) {
//		ModelAndView mv = new ModelAndView("delete.jsp");
//		Alien alien = repo.findById(aid).orElse(new Alien());
//		repo.deleteById(aid);
//		mv.addObject(alien);
//		return mv;
//		
//	}
	
	
	@PutMapping("/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		return alien;
	}
	
	@GetMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		System.out.println(repo.findByTech("IE"));
		System.out.println(repo.findByAidGreaterThan(102));
		
		System.out.println(repo.findByTechSorted("IE"));
		
		mv.addObject(alien);
		return mv;
	}
	
	@GetMapping("/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	//Create a service from wild card with path variable
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien2(@PathVariable int aid) {
		return repo.findById(aid);
	}

}
