
package com.cur.opertaion.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cur.opertaion.beans.Book;

/**
 * @author vishal
 *
 */
@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByPrice(Long price);

	Book findByBookName(String bookName);

}
