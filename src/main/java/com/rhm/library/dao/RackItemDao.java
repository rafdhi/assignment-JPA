package com.rhm.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rhm.library.entity.RackItem;

public interface RackItemDao extends CrudRepository<RackItem, Long>{
	
	@Query("select sum(quantity) "
			+ "from RackItem "
			+ "where rack.id = :id")
	public Integer findQuantityByRackId(@Param("id") Long id);
	
	@Query("select quantity "
			+ "from RackItem "
			+ "where libraryItem.id = :id")
	public List<Integer> findQuantityByLibraryId(@Param("id") Long id);
	
	@Query("select ri.quantity from RackItem ri "
			+ "where ri.rack.id = :rackId "
			+ "and ri.libraryItem.id = :libraryItemId")
	public Integer findQuantityById(@Param("rackId") Long rackId,@Param("libraryItemId") Long libraryItemId);
	
	@Query("select ri from RackItem ri "
			+ "where ri.rack.id = :rackId "
			+ "and ri.libraryItem.id = :libraryItemId")	
	public List<RackItem>findByLibItemRackId(@Param("rackId") Long rackId,@Param("libraryItemId") Long libraryItemId);
//	public List<RackItem>findByRackId(Long rackId);
	
	@Query("select ri from RackItem ri "
			+ "where ri.libraryItem.id = :libraryItemId")	
	public List<RackItem>findByLibItemId(@Param("libraryItemId") Long libraryItemId);
	
}
