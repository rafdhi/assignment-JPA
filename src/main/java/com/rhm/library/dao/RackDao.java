package com.rhm.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rhm.library.entity.Rack;

public interface RackDao extends CrudRepository<Rack, Long>{
	public Integer findById(Integer id);
	
	@Query("select r.id "
			+ "from Rack r "
			+ "where r.code = :code")
	public List<Long> findIdByCode(@Param("code") String code);
	
	public List<Rack> findByCode(String code);
	
//	public List<Rack> getAll();
//		
//	public Rack getById(int id);
//	
//	public void save(Rack rack);
//	
//	public void update(Rack rack);
//	
//	public void delete(int id);
//	

}
