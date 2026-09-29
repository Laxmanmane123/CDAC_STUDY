package com.artisanavenue.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name =  "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Category {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true, length = 100)
	private String name;
	
	@Column(columnDefinition = "Text")
	private String description;
	
}
