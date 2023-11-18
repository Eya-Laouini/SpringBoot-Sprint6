package com.ons.food.model.entities;


import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Choix {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idChoix;
	private String nomChoix;
	private String caracteristiqueChoix;
	
	@JsonIgnore
	@OneToMany (mappedBy = "choix")
	
	private List<Food> food;
	
	
}