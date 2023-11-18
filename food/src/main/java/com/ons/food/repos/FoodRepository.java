package com.ons.food.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ons.food.model.entities.Choix;
import com.ons.food.model.entities.Food;


public interface FoodRepository extends JpaRepository<Food, Long> {

	
	List<Food> findByNomFood(String nom);
	List<Food> findByNomFoodContains(String nom);
	
	/*@Query("select f from Food f where f.nomFood like %?1 and f.prixFood > ?2")
	List<Food> findByNomPrix (String nom, Double prix);*/
	
	@Query("select f from Food f where f.nomFood like %:nom and f.prixFood > :prix")
	List<Food> findByNomPrix (@Param("nom") String nom,@Param("prix") double prix);
	
	@Query("select p from Food p where p.choix = ?1")
	List<Food> findByChoix (Choix choix);
	
	List<Food> findByChoixIdChoix(Long id);
	
	List<Food> findByOrderByNomFoodAsc();

	@Query("select f from Food f order by f.nomFood ASC, f.prixFood ASC")
	List<Food> trierFoodNomsPrix ();



}
