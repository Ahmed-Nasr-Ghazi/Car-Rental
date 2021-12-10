package com.rent.crud.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rent.crud.entity.Car;


class Sortbyname implements Comparator<Car> {
	@Override
	public int compare(Car o1, Car o2) {
        return o1.getName().compareTo(o2.getName());
	}
}


@ExtendWith(SpringExtension.class)
class CarDAOImplTest {

	@Autowired
	private CarDAO carDAO;
	
/*
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
*/
	@Test
	@Transactional	
	void testFindAll() {
		//when
		List<Car> expectedCarList = carDAO.findAll();
		//then
		assertNotNull(expectedCarList);	
	}

	@Test
	@Transactional
	void testFindById() {
		//given
		Car car = new Car("Honda", "Red", 2010, "Company", "active");
		carDAO.save(car);
		//when
		Car expectedCar = carDAO.findById(car.getId());
		//then
		assertEquals(expectedCar, car);
	}
	
	@Test
	@Transactional
	void testSave() {
		//given
		Car car = new Car("Honda", "Red", 2010, "Company", "active");	
		//when
		carDAO.save(car);
		//then
		Car expectedCar = carDAO.findById(car.getId());
		assertEquals(expectedCar, car);
	}

	@Test
	@Transactional
	void testDeleteById() {
		//given
		Car car = new Car("Honda", "Red", 2010, "Company", "active");	
		//when
		carDAO.deleteById(car.getId());
		//then
		Car expectedCar = carDAO.findById(car.getId());
		assertNull(carDAO.findById(car.getId()));
	}

	@Test
	@Transactional
	void testSortByName() {
		
		//Given
		List<Car> expectedCarList = carDAO.findAll();
		Collections.sort(expectedCarList, new Sortbyname());
		List<Car> sortedCarList = carDAO.sortByName();
		//when
		carDAO.sortByName();
		//then
		assertEquals(expectedCarList, sortedCarList);

	}

	@Test
	@Transactional
	void testFindByName() {
		//given
		Car car = new Car("Honda", "Red", 2010, "Company", "active");
		carDAO.save(car);
		//when
		List<Car> expectedList = carDAO.findByName(car.getName());
		//then
		assertTrue(expectedList.contains(car));
	}

}
