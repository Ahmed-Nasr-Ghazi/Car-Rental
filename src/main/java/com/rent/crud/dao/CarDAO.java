package com.rent.crud.dao;

import java.util.List;

import com.rent.crud.entity.Car;

public interface CarDAO {

	public List<Car> findAll();
	
	public Car findById(int theId);
	
	public void save(Car theCar);
	
	public void deleteById(int theId);

	public List<Car> sortByName();
}
