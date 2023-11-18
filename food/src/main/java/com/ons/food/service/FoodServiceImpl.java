package com.ons.food.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ons.food.model.entities.Choix;
import com.ons.food.model.entities.Food;
import com.ons.food.model.entities.dto.FoodDTO;
import com.ons.food.repos.FoodRepository;
import com.ons.food.repos.ImageRepository;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	FoodRepository foodRepository;
	@Autowired
	ImageRepository imageRepository;
	@Autowired
	ModelMapper modelMapper;

	
	@Override
	public FoodDTO saveFood(FoodDTO f) {
		return 	convertEntityToDto(foodRepository.save(convertDtoToEntity(f)));
	}

	/*@Override
	public Food updateFood(Food f) {
		return 	foodRepository.save(f);
	}*/
	@Override
	public FoodDTO updateFood(FoodDTO f) {
	 return convertEntityToDto(foodRepository.save(convertDtoToEntity(f)));}

	@Override
	public void deleteFood(Food f) {
		 	foodRepository.delete(f);
		
	}

	@Override
	public void deleteFoodById(Long id) {
		foodRepository.deleteById(id);
		}
	

	

	@Override
	public List<FoodDTO> getAllFood() {
		return foodRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Food> findByNomFood(String nom) {
		return foodRepository.findByNomFood(nom);
	}

	@Override
	public List<Food> findByNomFoodContains(String nom) {
		return foodRepository.findByNomFoodContains(nom) ;
	}

	@Override
	public List<Food> findByNomPrix(String nom, Double prix) {
		
		return foodRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Food> findByChoix(Choix choix) {
		
		return foodRepository.findByChoix(choix);
	}

	@Override
	public List<Food> findByChoixIdChoix(Long id) {
		
		return foodRepository.findByChoixIdChoix(id);
	}

	@Override
	public List<Food> findByOrderByNomFoodAsc() {
		
		return foodRepository.findByOrderByNomFoodAsc();
	}

	@Override
	public List<Food> trierFoodNomsPrix() {
		
		return foodRepository.trierFoodNomsPrix();
	}
	@Override
	public FoodDTO getFood(Long id) {
		return convertEntityToDto( foodRepository.findById(id).get());
	}

	@Override
	public FoodDTO convertEntityToDto(Food food) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
FoodDTO foodDTO = modelMapper.map(food, FoodDTO.class);
		 return foodDTO;
	}
		
		
		
		/* return FoodDTO.builder().idFood(food.getIdFood())
				 .nomFood(food.getNomFood())
				 .prixFood(food.getPrixFood())
				 .datePreparation(food.getDatePreparation())
				 .choix(food.getChoix())
				 //.nomChoix(food.getChoix().getNomChoix())
				 .build()*/


	@Override
	public Food convertDtoToEntity(FoodDTO foodDto) {
		Food food = new Food();
		food = modelMapper.map(foodDto, Food.class);
		return food;
		
		
		
		
		/*Food food = new Food();
		food.setIdFood(foodDto.getIdFood());
		food.setNomFood(foodDto.getNomFood());
		food.setPrixFood(foodDto.getPrixFood());
		food.setDatePreparation(foodDto.getDatePreparation());
		food.setChoix(foodDto.getChoix()); 
		 return food;*/ 
	}
	

}
