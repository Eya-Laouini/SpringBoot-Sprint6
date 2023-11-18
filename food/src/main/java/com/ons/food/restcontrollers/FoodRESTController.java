package com.ons.food.restcontrollers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ons.food.model.entities.Food;
import com.ons.food.model.entities.dto.FoodDTO;
import com.ons.food.service.FoodService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FoodRESTController {
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<FoodDTO> getAllFood()
	{
		return foodService.getAllFood();
	}
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	
	public FoodDTO getProduitById(@PathVariable("id") Long id) {
		return foodService.getFood(id);
	 }
	@RequestMapping(value="/addfood",method = RequestMethod.POST)
	//@PostMapping("addfood")
	public FoodDTO createfood(@RequestBody FoodDTO foodDTO) {
		return foodService.saveFood(foodDTO);
	}
	@RequestMapping(value="/updatefood",method = RequestMethod.PUT)
	public FoodDTO updateFood(@RequestBody FoodDTO foodDTO) {
	return foodService.updateFood(foodDTO);
	}
	
	@RequestMapping(value="/delfood/{id}",method = RequestMethod.DELETE)
	public void deleteFood(@PathVariable("id") Long id)
	{
		foodService.deleteFoodById(id);
	}
	@RequestMapping(value="/foodschx/{idChoix}",method = RequestMethod.GET)
	public List<Food> getFoodsByChoixId(@PathVariable("idChoix") Long idChoix) {
		return foodService.findByChoixIdChoix(idChoix);
	}

	@RequestMapping(value="/foodsByName/{nom}",method = RequestMethod.GET)
	public List<Food> findByNomProduitContains(@PathVariable("nom") String nom) {
	return foodService.findByNomFoodContains(nom);
	}



}
