package com.rhm.library.dao;
//package com.trieka.library.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//
//import com.trieka.library.dao.RackDao;
//import com.trieka.library.entity.Rack;
//
//@Repository
//public class RackDaoImpl implements RackDao{
//	@PersistenceContext
//	EntityManager entityManager; 
//	
//	@Override
//	public List<Rack> getAll(){
//		return entityManager.createQuery("select r from Rack r", Rack.class).getResultList();
//	}
//	
//	@Override
//	public Rack getById(int id) {
//		return entityManager.find(Rack.class, id);
//	}
//	
//	@Override
//	public List<Rack>findById(Long id) {
//		return (List<Rack>) entityManager.find(Rack.class, id);
//	}
//	
//
//	@Transactional
//	@Override
//	public void save (Rack rack) {
//		entityManager.persist(rack); 
//	}
//	
//	@Transactional
//	@Override
//	public void update(Rack rack) {
//		entityManager.merge(rack);
//	}
//	
//	@Transactional
//	@Override
//	public void delete(int id) {
//		Rack rack = getById(id);	
//		entityManager.remove(rack);
//	}
//	
//	
//}
