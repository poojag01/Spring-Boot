package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
		PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}

	private void initData() {
		
		//eric
		Author eric = new Author( "Eric" , "Evans");
		Publisher xyz = new Publisher( "ABC", "Address");
		publisherRepository.save(xyz);
		Book ddd = new Book( "Domain Driven Design" , "1234", xyz	);
		eric.getBooks().add( ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//rod
		Author rod = new Author("Rod", "Johnson");
		Publisher worx = new Publisher( "Worx", "Add2");
		publisherRepository.save(worx);
		Book noEJB = new Book( "J2EEE Development without EJB" , "123444" , worx);
		//Book noEJB = new Book(title: "J2EEE Development without EJB" , isbn: 123444, publisher: "Worx");
		rod.getBooks().add( noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}

}
