package com.rhm.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rhm.library.entity.Author;

public interface AuthorDao extends CrudRepository<Author, Long>{
	// Mencari id berdasarkan nama Author
		@Query("select au.id "
				+ "from Author au "
				+ "where au.name = :name")
		public List<Long> findIdByName(@Param("name") String name);
	
}
