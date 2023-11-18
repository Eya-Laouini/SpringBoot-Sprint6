package com.ons.food;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ons.food.model.entities.Choix;
import com.ons.food.model.entities.Food;
import com.ons.food.repos.FoodRepository;

@SpringBootTest
class FoodApplicationTests {

	@Autowired
	private FoodRepository foodRepository;
	
	@Test
	public void testCreateFood()
	{
		Food fds = new Food("salade",12.300,new Date());
		foodRepository.save(fds);
	}

	@Test
	public void testUpdateFood()
	{
		Food f=foodRepository.findById(3L).get();
		f.setNomFood("pizza");
		foodRepository.save(f);
		System.out.println(f);
	}
	@Test
	public void testDeleteFood()
	{
		foodRepository.deleteById(1L);
		
	}
	@Test
	public void testFindAllFood()
	{
		List<Food> foods = foodRepository.findAll();
		for (Food f:foods)
			System.out.println(f);
		
	}
	@Test
	public void testFindFoodByNom()
	{
		List<Food> foods=foodRepository.findByNomFood("chawarma");
		for (Food f:foods)
			System.out.println(f);
	}
	@Test
	public void testFindFoodByNomContains()
	{
		List<Food> foods=foodRepository.findByNomFoodContains("c");
		for (Food f:foods)
			System.out.println(f);
	}
	@Test
	public void testfindByNomPrix()
	{
	List<Food> foods = foodRepository.findByNomPrix("pizza", 6500.0);
	for (Food f : foods)
	{
	System.out.println(f);
	}
	}
	
@Test
	public void testfindByChoix()
	{
	Choix choix = new Choix();
	choix.setIdChoix(1L);
	List<Food> foods = foodRepository.findByChoix(choix);
	for (Food f : foods)
	{
	System.out.println(f);
	}
	}
@Test
public void findByChoixIdChoix()
{
List<Food> foods = foodRepository.findByChoixIdChoix(1L);
for (Food f : foods)
{
System.out.println(f);
}
 }

@Test
public void testfindByOrderByNomFoodAsc()
{
List<Food> foods = foodRepository.findByOrderByNomFoodAsc();
for (Food f : foods)
{
System.out.println(f);
}
}

@Test
public void testTrierFoodNomsPrix()
{
List<Food> foods = foodRepository.trierFoodNomsPrix();
for (Food f : foods)
{
System.out.println(f);
}
}




}
