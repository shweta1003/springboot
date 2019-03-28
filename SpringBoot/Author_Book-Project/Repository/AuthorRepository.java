
package com.cur.opertaion.interfaces;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cur.opertaion.beans.Author;

/**
 * @author vishal
 *
 */
@Repository
@Transactional
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Author findByAuthorName(String authorName);

	Iterable<Author> findByAuthorNameContaining(String authorName);

	Iterable<Author> findByCity(String city);

	Optional<Author> findByAuthorId(Long authorId);

}
