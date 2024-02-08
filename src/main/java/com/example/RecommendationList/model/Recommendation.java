package com.example.RecommendationList.model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document
public class Recommendation {
	public enum Category {
		Movie,
		VideoGame,
		TVshow,
		Music,
		YoutubeVideo,
		Book
	}
	@Id
	private String id;
	private String name;
	private String author;
	private String description;
	private LocalDate date;
	@Enumerated(EnumType.STRING)
	private Category category;

	public Recommendation(){
	}

	public Recommendation(String id, String name, String author, String description, LocalDate date, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
		this.date = date;
		this.category = category;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
