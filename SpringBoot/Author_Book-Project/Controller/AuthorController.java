
package com.cur.opertaion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	BookRepository bookR;

	@Autowired
	AuthorRepository authorR;

	List<Book> books = new ArrayList<>(1000);
	Author authors = new Author();

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public Iterable<Author> getAll() {
		return authorR.findAll();
	}

	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public Iterable<Author> saveAuthor(@RequestBody final Author author) {

		System.out.println("Author" + author);

		authorR.save(author);

		return authorR.findAll();

	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Optional<Author> getAllCommentsByPostId(@RequestParam(value = "authorId") Long authorId, Author author) {
		return authorR.findById(authorId);
	}

	@RequestMapping(value = "/getByName", method = RequestMethod.GET)
	public Author findByAuthorName(@RequestParam(value = "authorName") String authorName) {

		return authorR.findByAuthorName(authorName);
	}

	@RequestMapping(value = "/LikeShow", method = RequestMethod.GET)
	public Iterable<Author> findByAuthorNameContaining(@RequestParam(value = "authorName") String authorName) {
		return authorR.findByAuthorNameContaining(authorName);
	}

	@RequestMapping(value = "/ShowByCity", method = RequestMethod.GET)
	public Iterable<Author> findByCity(@RequestParam(value = "city") String city) {
		return authorR.findByCity(city);
	}

	@RequestMapping(value = "/showByBook", method = RequestMethod.GET)
	public Book findByBookName(@RequestParam(value = "bookName") String bookName) {
		return bookR.findByBookName(bookName);
	}

	@RequestMapping(value = "/showByPrice", method = RequestMethod.GET)
	public List<Book> findByPrice(@RequestParam(value = "price") Long price) {
		return bookR.findByPrice(price);
	}

	@RequestMapping(value = "/updateAutho", method = RequestMethod.PUT)
	public Author updateAuthor(@Valid @RequestBody Author postRequest) {

		return authorR.findById(postRequest.getAuthorId()).map(author -> {

			author.setAuthorName(postRequest.getAuthorName());
			author.setCity(postRequest.getCity());

//			List<Book> newBooks = new ArrayList<>();
//			
//			for(Book book : postRequest.getBook()) {
//				
//			newBooks.add(book);
//				
//			}

			author.setBook(postRequest.getBook());

			return authorR.save(author);

		}).orElseThrow(() -> new ResourceAccessException("a_id  not found"));

	}

	@RequestMapping(value = "/del", method = RequestMethod.DELETE)
	public void delete() {
		authorR.deleteAll();
	}

}
