package com.rhm.library;

import java.security.AuthProvider;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rhm.library.dao.AuthorDao;
import com.rhm.library.dao.LibraryItemDao;
import com.rhm.library.dao.RackDao;
import com.rhm.library.dao.RackItemDao;
import com.rhm.library.entity.Author;
import com.rhm.library.entity.LibraryItem;
import com.rhm.library.entity.Rack;
import com.rhm.library.entity.RackItem;


@Configuration
public class BeanClass {
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private LibraryItemDao libraryItemDao;
	
	@Autowired
	private RackItemDao rackItemDao;
	
	@Autowired
	private RackDao rackDao;
	

//	=============================================================================================================
//	=========================================== Add Stok =====================================================
//	=============================================================================================================
	@Bean
	@Transactional
	public void addStock() {
			
		Author author = new Author();
//		Long auId = 1L;
		String authorName = "Dan Brown";
		
//		author.setId(auId);
		author.setName(authorName);
		System.out.println(author.getId());
		Rack rack = new Rack();
		LibraryItem item = new LibraryItem();
		
		String code = "B-21";
		String title = "Angel and Demon";
		String type = "Book";
		String isbn = "231231231";
		
		rack.setCode(code);
		item.setTitle(title);
		item.setType(type);
		item.setAuthor(author);
		item.setIsbn(isbn);
		
		System.out.println(author.getName());
		System.out.println(item.getTitle());
		Integer quantity = 2;
//		=========================================================================================
		RackItem rackItem = new RackItem();
		RackItem rackItem2 = new RackItem();
		
		libraryItemDao.save(item);
		authorDao.save(author);
		
		
		LibraryItem libItem = new LibraryItem();
		System.out.println("===============");
		Long rackId = rackDao.findIdByCode(code).stream().findFirst().orElse(null);
		System.out.println(code);
		Long libraryItemId = libraryItemDao.findIdByTitle(title).stream().findFirst().orElse(null);
		System.out.println(libraryItemId);
		Long authorId = authorDao.findIdByName(authorName).stream().findFirst().orElse(null);
		System.out.println(authorId);
//			=================== Find Library Item Id and Rack Id
		rackItem = rackItemDao.findByLibItemRackId(rackId,libraryItemId).stream().findFirst().orElse(null); 
		System.out.println(authorId);
		System.out.println("-------------------------------------");
		if(rackItem != null) {
			if (authorId == null) {
				System.out.println("author null");
				//authorDao.save(author);
				authorDao.save(author);
				System.out.println("berhasil disimpan");
			}
			// add quantity
			quantity = rackItemDao.findQuantityById(rackId, libraryItemId);
			rackItem.setQuantity(quantity);
			rackItemDao.save(rackItem);
		}else {
			if (authorId == null) {
				System.out.println("author null");
				authorDao.save(author);
			}
			if (rackId != null) {
				libraryItemDao.save(item);
			}
			if (libraryItemId != null) {
				System.out.println("123");
				rackDao.save(rack);				
			}
			rackItem2.setLibraryItem(libraryItemDao.findByTitle(title).stream().findFirst().get());
			rackItem2.setRack(rackDao.findByCode(code).stream().findFirst().get());
			rackItemDao.save(rackItem2);
			rackItem2.setQuantity(quantity);
			
			System.out.println("Table Rack Telah ditambahkan");
		}

	}
//	=============================================================================================================
//	=========================================== Reduce Stok =====================================================
//	=============================================================================================================

	
//	@Bean
//	@Transactional
	public void reduceStock() {
			

		Rack rack = new Rack();	
		RackItem rackItem = new RackItem();
		RackItem rackItem2 = new RackItem();
		
		LibraryItem libItem = new LibraryItem();
		
		Long rID = 2L;
		Long lID = 3L;
		Integer  redQtt = 1;
		Integer quantity;


		rackItem = rackItemDao.findByLibItemRackId(rID,lID).stream().findFirst().orElse(null); 
		System.out.println(rackItem.getQuantity());
		
		if(rackItem != null) {
		// add quantity
			quantity = rackItemDao.findQuantityById(rID, lID)-redQtt;
			System.out.println(quantity);
			
			if (quantity == 0) {
				rackItemDao.delete(rackItem);
			}else if (quantity < 0) {
				rackItemDao.delete(rackItem);
				while (quantity < 0) {
					System.out.println("===================================");
					System.out.println();
					
					RackItem rackReduce = new RackItem();
					rackReduce = rackItemDao.findByLibItemId(lID).stream().findAny().orElse(null);
					System.out.println(rackReduce.getQuantity());
					System.out.println(rackReduce.getLibraryItem());
					System.out.println(rackReduce.getRack().getId());
					Integer reduceItem = (rackReduce.getQuantity())-(quantity*(-1));
					System.out.println(reduceItem);
					System.out.println(quantity);
					if (reduceItem > 0) {
						rackReduce.setQuantity(reduceItem);		
						rackItemDao.save(rackReduce);
						quantity = reduceItem;
					}else if (reduceItem == 0) {
						System.out.println("delllllll");
						rackItemDao.delete(rackReduce);
						break;
					}else {
						quantity = reduceItem;
					}
					
				}			
			}else {
				rackItem.setQuantity(quantity);
				rackItemDao.save(rackItem);
			}
		}
	}
	
//	=============================================================================================================
//	=============================================================================================================
	
}
	