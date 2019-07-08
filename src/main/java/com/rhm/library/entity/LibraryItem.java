package com.rhm.library.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "library_item")
public class LibraryItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	
	@Column
	private String isbn;
	
	@Column(name = "publish_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishDate;
}
