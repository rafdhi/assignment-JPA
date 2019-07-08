package com.rhm.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rhm.library.entity.LibraryItem;
import com.rhm.library.entity.Rack;

public interface LibraryItemDao extends CrudRepository<LibraryItem, Long>{
	
	public List<LibraryItem>findByTitle(String title);

	
//	Mencari library_item berdasarkan nama author
	@Query("select li "
		+ "from LibraryItem li "
		//+ "join li.author au "
		//+ "group by li.libraryItem.id "
		+ "where li.author.name = :name")
	public List<LibraryItem> findLibraryItemByName(@Param("name") String name);
	//_________________________________________________________________________
//	Mencari library_item dengan tipe Book berdasarkan isbn
	@Query("select li.title, "
				+ "li.type "
			+ "from LibraryItem li "
			+ "where li.isbn = :isbn")
	public List<Object[]> findLibraryItemByIsbn(@Param("isbn")String isbn);
	//_________________________________________________________________________

//	Mencari library_item dengan tipe Book berdasarkan author (id)
	@Query("select li.title, "
			+ "li.type "
		+ "from LibraryItem li "
		+ "where li.author.id = :authorId")
	public List<Object[]> findLibraryItemByAuthorId(@Param("authorId")Long authorId);
	
// Mencari id berdasarkan judul buku
	@Query("select li.id "
			+ "from LibraryItem li "
			+ "where li.title = :title")
	public List<Long> findIdByTitle(@Param("title") String title);


}
/* ==== native query ====
	Select * from library_item li
	join author au on au.id = li.author_id
	where au.name = 'Jack Fulan'
 */
