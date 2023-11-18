package com.ons.food.restcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ons.food.model.entities.Choix;
import com.ons.food.repos.ChoixRepository;

@RestController
@RequestMapping("/api/choix")
@CrossOrigin("*")
public class ChoixRESTController {
	
	
	@Autowired
	ChoixRepository choixRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Choix> getAllChoix()
	{
		return choixRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Choix getChoixById(@PathVariable("id") Long id) {
		return choixRepository.findById(id).get();
	}
	
	
}
