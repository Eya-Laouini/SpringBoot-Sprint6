package com.ons.food.model.entities.dto;

import java.util.Date;
import java.util.List;

import com.ons.food.model.entities.Choix;
import com.ons.food.model.entities.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDTO {
	private Long idFood;
	private String nomFood;
	private Double prixFood;
	private Date datePreparation;
	private Choix choix;
	private String nomChoix;
	private List<image> images;

}
