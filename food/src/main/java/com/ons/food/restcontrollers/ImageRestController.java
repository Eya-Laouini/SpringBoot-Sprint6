package com.ons.food.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ons.food.model.entities.image;
import com.ons.food.service.ImageService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	 ImageService imageService ;
	 
	 
	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException 
	{
	 return imageService.getImage(id);
	 }
	 
	 
	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 
	 @PostMapping(value = "/uplaodImageFood/{idFood}" )
	 public image uploadMultiImages(@RequestParam("image")MultipartFile file,
	 @PathVariable("idFood") Long idFood) 
	throws IOException {
	 return imageService.uplaodImageFood(file,idFood);
	 }
	@RequestMapping(value = "/getImagesProd/{idFood}" , 
	 method = RequestMethod.GET)
	 public List<image> getImagesFood(@PathVariable("idFood") Long idFood) 
	throws IOException {
	 return imageService.getImagesParFood(idFood);
	 }

	}
	

	 
	 
	 
	 
	