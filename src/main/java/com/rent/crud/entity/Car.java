package com.rent.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
@Table(name="car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="color")
	private String color;
	
	@Column(name="model")
	private int model;
	
	@Column(name="owner")
	private String owner;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="hide_me")
	private String hideMe;

	//constructors
	public Car() {
		
	}
	
	public Car(String name, String color, int model, String owner, String hideMe) {
		this.name = name;
		this.color = color;
		this.model = model;
		this.owner = owner;
		this.hideMe = hideMe;
	}

	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getHideMe() {
		return hideMe;
	}

	public void setHideMe(String hideMe) {
		this.hideMe = hideMe;
	}

	//define toString method
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", color=" + color + ", model=" + model + ", owner=" + owner
				+ ", hideMe=" + hideMe + "]";
	}
	
	
	
	
	
	
}
