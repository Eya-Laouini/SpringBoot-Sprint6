package com.ons.food.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ons.food.model.entities.Food;
import com.ons.food.model.entities.image;
import com.ons.food.repos.FoodRepository;
import com.ons.food.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
 @Autowired
 ImageRepository imageRepository;
 @Autowired
 FoodRepository foodRepository;

 @Autowired
FoodService foodService;

 @Override
 public image uplaodImage(MultipartFile file) throws IOException {
 /*Ce code commenté est équivalent au code utilisant le design pattern Builder
 * Image image = new Image(null, file.getOriginalFilename(), 
 file.getContentType(), file.getBytes(), null);
 return imageRepository.save(image);*/
 return imageRepository.save(image.builder()
 .name(file.getOriginalFilename())
 .type(file.getContentType())
 .image(file.getBytes()).build() );
 }
 @Override
 public image getImageDetails(Long id) throws IOException{
 final Optional<image> dbImage = imageRepository. findById (id);
 return image.builder()
 .idImage(dbImage.get().getIdImage())
 .name(dbImage.get().getName())
 .type(dbImage.get().getType())
 .image(dbImage.get().getImage()).build() ;
 }
 @Override
 public ResponseEntity<byte[]> getImage(Long id) throws IOException{
 final Optional<image> dbImage = imageRepository. findById (id);
 return ResponseEntity
 .ok()
 .contentType(MediaType.valueOf(dbImage.get().getType()))
 .body(dbImage.get().getImage());
 }
 @Override
 public void deleteImage(Long id) {
 imageRepository.deleteById(id);
 }
 
 @Override
 public image uplaodImageFood(MultipartFile file,Long idFood) 
 throws IOException {
 Food f = new Food();
 f.setIdFood(idFood);
 return imageRepository.save(image.builder()
  .name(file.getOriginalFilename())
  .type(file.getContentType())
  .image(file.getBytes())
  .food(f).build() );
 }
 
 @Override
 public List<image> getImagesParFood(Long foodId) {
 Food f = foodRepository.findById(foodId).get();
 return f.getImages();
 }

}

