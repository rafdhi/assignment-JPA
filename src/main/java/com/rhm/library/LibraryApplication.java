package com.rhm.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rhm.library.dao.AuthorDao;
import com.rhm.library.dao.LibraryItemDao;
import com.rhm.library.dao.RackDao;
import com.rhm.library.dao.RackItemDao;
import com.rhm.library.entity.Author;
import com.rhm.library.entity.LibraryItem;
import com.rhm.library.entity.Rack;
import com.rhm.library.entity.RackItem;

@SpringBootApplication
public class LibraryApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		
		
	}
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private LibraryItemDao libraryItemDao;
	
	@Autowired
	private RackItemDao rackItemDao;
	
	@Autowired
	private RackDao rackDao;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		//authorDao.findAll().forEach(System.out::println);
		System.out.println("======================== Find Library Item by Name =========================");
		libraryItemDao.findLibraryItemByName("Jack Fulan").forEach(System.out::println);
//
//		
		System.out.println("======================== Find Library Item by Name =========================");
//		List<Object[]> isbn = libraryItemDao.findLibraryItemByIsbn("1245398461579");
//		
//		for (Object[] obj : isbn) {
//			System.out.println("Title : " + obj[0]);
//			System.out.println("Type Book : " + obj[1]);
//		}
//		
		//======================== Find Library Item by Author Id ==========================
//		System.out.println("======================== Find Library Item by Author Id =========================");
//		List<Object[]> authorId = libraryItemDao.findLibraryItemByAuthorId(2L);
//		
//		for (Object[] obj : authorId ){
//			System.out.println("Title : " + obj[0]);
//			System.out.println("Type Book : " + obj[1]);
//		}
		
		//======================== Find Library Item by Rack Id ==========================
//		System.out.println("======================== Find Library Item by Rack Id =========================");
//		
//		Long id = 2L;
//		Integer rackQntt= rackItemDao.findQuantityByRackId(id);
//		
//		System.out.print("Jumlah item per rack untuk id ="+id + " : ");
//		System.out.println(rackQntt);
//		System.out.println("=============================================================================");

//	}
//		Author author = new Author();
////		Long auId = 1L;
//		String authorName = "Jack Ma";
//		
////		author.setId(auId);
//		author.setName(authorName);
//		Rack rack = new Rack();
//		LibraryItem item = new LibraryItem();
//		
//		String code = "North-04";
//		String title = "Coming Home";
//		String type = "Book";
//		String isbn = "1245398461579";
//		
//		rack.setCode(code);
//		item.setTitle(title);
//		item.setType(type);
//		item.setAuthor(author);
//		item.setIsbn(isbn);
//		
//		System.out.println(rack.getCode());
//		System.out.println(item.getTitle());
//		
//		Integer quantity = 2;
////		=========================================================================================
//		RackItem rackItem = new RackItem();
//		RackItem rackItem2 = new RackItem();
//		
//		//@Bean
//		TransBean transBean = new TransBean();
//		transBean.addStock(author, rack, item, quantity);
	
	}
	
	
}
