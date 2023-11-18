package com.ons.food.model.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomFood", types = { Food.class })
public interface FoodProjection {

 public String getNomFood();
}
