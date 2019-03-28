
package com.cur.opertaion.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.cur.opertaion.beans.Author;
import com.cur.opertaion.beans.Book;
import com.cur.opertaion.interfaces.AuthorRepository;
import com.cur.opertaion.interfaces.BookRepository;

/**
 * @author vishal
 *
 */
@RestController
@RequestMapping(value = "/author")
public class BookController {

	@Autowired
	BookRepository bookR;

	@Autowired
	AuthorRepository authorR;
/*
	@GetMapping("/show/{aid}")
	public Iterable<Book> getAll() {
		return bookR.findAll();
	}

	@GetMapping("/get1/{authorId}")
	public Optional<Author> getAllCommentsByPostId(@PathVariable(value = "authorId") Long authorId, Author author) {
		return authorR.findById(authorId);
	}

	@RequestMapping(value = "/getName/{authorName}", method = RequestMethod.GET)
	public Author findByAuthorName(@PathVariable(value = "authorName") String authorName, Author author) {

		return authorR.findByAuthorName(authorName);

	}

	@RequestMapping(value = "/updateAuthor/{authorId}", method = RequestMethod.PUT)
	public Author updateAuthor(@PathVariable(value = "authorId") Long authorId,
			@Valid @RequestBody Author postRequest) {
		return authorR.findById(authorId).map(author -> {
			author.setAuthorName(postRequest.getAuthorName());
			author.setCity(postRequest.getCity());
			author.setBook(postRequest.getBook());
			return authorR.save(author);
		}).orElseThrow(() -> new ResourceAccessException("a_id " + authorId + " not found"));
	}
	*/

}
