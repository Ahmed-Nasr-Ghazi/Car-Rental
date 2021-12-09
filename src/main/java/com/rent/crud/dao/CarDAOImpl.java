package com.rent.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rent.crud.entity.Car;

@Repository
public class CarDAOImpl implements CarDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Car> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Car", Car.class);
		List<Car> list = query.getResultList();
		return list;
	}

	@Override
	public Car findById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Car theCar = session.get(Car.class, theId);
		return theCar;
	}

	@Override
	public void save(Car theCar) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theCar);
	}

	@Override
	public void deleteById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Car where id=:carId");
		query.setParameter("carId", theId);
		query.executeUpdate();
	}

	@Override
	public List<Car> sortByName() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Car order by name", Car.class);
		List<Car> list = query.getResultList();
		return list;
	}

	@Override
	public List<Car> sortByModel() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Car order by model DESC", Car.class);
		List<Car> list = query.getResultList();
		return list;
	}

	@Override
	public List<Car> findByName(String carName) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Car c where c.name like :carName", Car.class);
		query.setParameter("carName", "%" + carName +"%");
		List<Car> list = query.getResultList();
		return list;
	}

	@Override
	public List<Car> findByOwner(String ownerName) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Car c where c.owner like :ownerName", Car.class);
		query.setParameter("ownerName", "%" + ownerName +"%");
		List<Car> list = query.getResultList();
		return list;
	}

}
