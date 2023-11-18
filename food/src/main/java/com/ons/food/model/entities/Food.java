package com.ons.food.model.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Food {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFood;
	private String nomFood;
	private Double prixFood;
	private Date datePreparation;
	
	@ManyToOne
	private Choix choix;
	
	/*@OneToOne
	private image image;*/
	
	 @OneToMany (mappedBy = "food")
	 private List<image> images;
	 
	public Food() {
		super();}
	
		
	public Food(String nomFood, Double prixFood, Date datePreparation) {
		super();
		this.nomFood = nomFood;
		this.prixFood = prixFood;
		this.datePreparation = datePreparation;
	}


	public Long getIdFood() {
		return idFood;
	}
	public void setIdFood(Long idFood) {
		this.idFood = idFood;
	}
	public String getNomFood() {
		return nomFood;
	}
	public void setNomFood(String nomFood) {
		this.nomFood = nomFood;
	}
	public Double getPrixFood() {
		return prixFood;
	}
	public void setPrixFood(Double prixFood) {
		this.prixFood = prixFood;
	}
	public Date getDatePreparation() {
		return datePreparation;
	}
	public void setDatePreparation(Date datePreparation) {
		this.datePreparation = datePreparation;
	}
	public Choix getChoix() {
		return choix;
	}


	public void setChoix(Choix choix) {
		this.choix = choix;
	}
	


	@Override
	public String toString() {
		return "Food [idFood=" + idFood + ", nomFood=" + nomFood + ", prixFood=" + prixFood + ", datePreparation="
				+ datePreparation +" ,choix="+choix+ "]";
	}


	public List<image> getImages() {
		return images;
	}


	public void setImages(List<image> images) {
		this.images = images;
	}


	





	
	

}
