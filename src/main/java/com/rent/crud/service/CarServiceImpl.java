package com.rent.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.crud.dao.CarDAO;
import com.rent.crud.entity.Car;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarDAO carDAO;
	
	@Override
	@Transactional
	public List<Car> findAll() {
		
		return carDAO.findAll();
	}

	@Override
	@Transactional
	public Car findById(int theId) {

		return carDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Car theCar) {
		
		carDAO.save(theCar);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		carDAO.deleteById(theId);
	}

	@Override
	public List<Car> sortByName() {
		return carDAO.sortByName();
	}

	@Override
	public List<Car> sortByModel() {
		return carDAO.sortByModel();
	}

}
