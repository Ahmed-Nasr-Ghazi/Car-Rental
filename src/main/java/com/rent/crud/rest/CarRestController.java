package com.rent.crud.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rent.crud.dao.CarDAO;
import com.rent.crud.entity.Car;
import com.rent.crud.exception.CarNotFoundException;
import com.rent.crud.service.CarService;

@RestController
@RequestMapping("/api")
public class CarRestController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/cars")
	public List<Car> findAll(){
		return carService.findAll();
	}
	
	@GetMapping("/cars/{carId}")
	public Car findById(@PathVariable int carId) {
		Car theCar = carService.findById(carId);
		if(theCar == null) {
			throw new CarNotFoundException("Car Not Found with id - "+ carId);
		}
		return theCar;	
	}
	
	@PostMapping("/cars")
	public Car addCar(@RequestBody Car theCar) throws Exception {
		int carModel = theCar.getModel();
		if(carModel > 2022 || carModel < 2000) {
			throw new Exception("Car model " + theCar.getModel() + " is out of date");
		}
		theCar.setId(0); //to force a save of new item
		carService.save(theCar);
		return theCar; 
	}
	
	@PutMapping("/cars")
	public Car updateCar(@RequestBody Car theCar) throws Exception { 
		int carModel = theCar.getModel();
		if(carModel > 2022 || carModel < 2000) {
			throw new Exception("Car model " + theCar.getModel() + " is out of date");
		}
		carService.save(theCar);
		return theCar;
	}
	
	@DeleteMapping("/cars/{carId}")
	public String deleteCar(@PathVariable int carId) {
		
		Car tempCar = carService.findById(carId);
		if(tempCar == null) {
			throw new CarNotFoundException("Car Not Found with id - "+ carId);
		}
		
		carService.deleteById(carId);
		return "Deleted the car with id " + carId;
		
	}
	
	@GetMapping("/cars/sortName")
	public List<Car> findAllSortByName(){
		return carService.sortByName();
		
	}
	
	@GetMapping("/cars/sortModel")
	public List<Car> findAllSortByModel(){
		return carService.sortByModel();
		
	}
	
	@GetMapping("/cars/searchName/{carName}")
	public List<Car> findAllByName(@PathVariable String carName){
		List<Car> theCar = carService.findByName(carName);
		if(theCar == null) {
			throw new CarNotFoundException("Car Not Found with name " + carName);
		}
		return theCar;			
	}
	
	@GetMapping("/cars/searchOwner/{carOwner}")
	public List<Car> findAllByOwner(@PathVariable String carOwner){
		List<Car> theCar = carService.findByOwner(carOwner);
		if(theCar == null) {
			throw new CarNotFoundException("Car Not Found with owner " + carOwner);
		}
		return theCar;			
	}
}
