package com.example.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;
	private String publisher;
	
	@ManyToMany
	private Set<Author> authors = new HashSet<>();
	
	public Book() {
		
	}
	
	public Book( String title, String isbn, String publisher) {
		this.title = title;
		this.publisher = publisher;
		this.isbn = isbn;
	}
	
	public Book( String title, String isbn, String publisher, Set<Author>author) {
		this.title = title;
		this.publisher = publisher;
		this.isbn = isbn;
		this.authors = author;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle( String title) {
		this.title = title;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher( String publisher) {
		this.publisher = publisher;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn( String isbn) {
		this.isbn = isbn;
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}
	
	public void setAuthors( Set<Author> authors) {
		this.authors = authors;
	}
	
	@Override
	public boolean equals( Object o) {
		if( this == o) return true;
		
		if( o == null || getClass() != o.getClass() ) return false;
		
		Book book = (Book ) o;
		return id != null ? id.equals( book.id ) : book.id == null ;
	}

	@Override
	public int hashCode() {
		
		return id != null ? id.hashCode() : 0 ;
	}
	
	@Override
	public String toString() {
		return "Book{ " + "id = " + id + " isbn = " + isbn + " title = '" + title + "' publisher = '" + publisher + "' authors = " + authors + "}" ;  
	}
	
}
