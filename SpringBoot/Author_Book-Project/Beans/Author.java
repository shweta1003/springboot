
package com.cur.opertaion.beans;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author vishal
 *
 */
@Entity
@Data
@Table(name = "author")
public class Author {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "AUTHOR_SEQ")
	@SequenceGenerator(name = "AUTHOR_SEQ", sequenceName = "AUTHOR_SEQ")
	private Long authorId;

	private String authorName;

	private String city;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Book> book;


}
