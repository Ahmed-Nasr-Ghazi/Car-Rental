package com.rent.crud.service;

import java.util.List;

import com.rent.crud.entity.Car;

public interface CarService {

public List<Car> findAll();
	
	public Car findById(int theId);
	
	public void save(Car theCar);
	
	public void deleteById(int theId);

	public List<Car> sortByName();

	public List<Car> sortByModel();

	public List<Car> findByName(String carName);

	public List<Car> findByOwner(String ownerName);

	
}
