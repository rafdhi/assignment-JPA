package com.rhm.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "rack_item")
public class RackItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "rack_id",nullable = false)
	private Rack rack;
	
	@ManyToOne
	@JoinColumn(name = "library_item_id",nullable = false)
	private LibraryItem libraryItem;
	
	@Column(nullable = false)
	private int quantity;
}