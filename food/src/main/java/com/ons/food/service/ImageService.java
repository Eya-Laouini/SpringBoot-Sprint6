package com.ons.food.service;


import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ons.food.model.entities.image;
public interface ImageService {
	
	
 image uplaodImage(MultipartFile file) throws IOException;
 image getImageDetails(Long id) throws IOException;
 ResponseEntity<byte[]> getImage(Long id) throws IOException;
 void deleteImage(Long id) ;
 image uplaodImageFood(MultipartFile file,Long idFood) throws IOException;
 List<image> getImagesParFood(Long FoodId);
 
}

