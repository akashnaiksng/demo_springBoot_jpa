package com.smart.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smart.demo.dao.AlienRepo;
import com.smart.demo.model.Alien;
import com.sun.el.stream.Optional;
@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int aid) {
		ModelAndView mv=new ModelAndView("showAlien.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGreaterThan(4));
		System.out.println(repo.findByTechSorted("Java"));
		mv.addObject(alien);
		return mv;
	}
	
	//response is in toString format
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens() {
		
		return repo.findAll().toString();
	}
	
	//response is in toString format
	@RequestMapping("/alien/2")
	@ResponseBody
	public String getAlien() {
		
		return repo.findById(2).toString();
	}
	
	//response is in toString format
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public String getAlienn(@PathVariable("aid") int aid) {
		
		return repo.findById(aid).toString();
	}
	
	//response is in JSON format
	@RequestMapping(value = "/alienss",produces = "application/xml")
	@ResponseBody
	public List<Alien> getAlienss() {
		
		return repo.findAll();
	}
	
	//response is in JSON format/Xml format
	@RequestMapping(value = "/alienn/{aid}", produces = "application/json")
	@ResponseBody
	public java.util.Optional<Alien> getAliennn(@PathVariable("aid") int aid) {
		
		return repo.findById(aid);
	}
	
	@PostMapping(value = "/addAlienn",consumes = "application/xml")
	@ResponseBody
	public Alien addAlienn(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping(value = "/deleteAlien/{aid}")
	@ResponseBody
	public String deleteAlien(@PathVariable("aid") int aid) {
		Alien a=repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping(value = "/updateAlienn")
	@ResponseBody
	public Alien updateAlienn(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
}
