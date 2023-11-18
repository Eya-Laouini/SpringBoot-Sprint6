package com.ons.food.service;

import java.util.List;

import com.ons.food.model.entities.Choix;
import com.ons.food.model.entities.Food;
import com.ons.food.model.entities.dto.FoodDTO;

public interface FoodService {
	FoodDTO saveFood(FoodDTO f);
	FoodDTO updateFood(FoodDTO f);
	void deleteFood(Food f);
	void deleteFoodById(Long id);
	FoodDTO getFood(Long id);
	List<FoodDTO> getAllFood();
	List<Food> findByNomFood(String nom);
	List<Food> findByNomFoodContains(String nom);
	List<Food> findByNomPrix (String nom, Double prix);
	List<Food> findByChoix (Choix choix);
	List<Food> findByChoixIdChoix(Long id);
	List<Food> findByOrderByNomFoodAsc();
	List<Food> trierFoodNomsPrix();
	FoodDTO convertEntityToDto (Food food);
	Food convertDtoToEntity(FoodDTO foodDto);
	

	




}
