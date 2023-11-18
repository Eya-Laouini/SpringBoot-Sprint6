package com.ons.food.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ons.food.model.entities.image;

public interface ImageRepository extends JpaRepository<image , Long>  {

}
