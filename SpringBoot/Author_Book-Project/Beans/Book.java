
package com.cur.opertaion.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author vishal
 *
 */
@Entity
@Data
@Table(name = "book")
public class Book {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "BOOK_SEQ")
	@SequenceGenerator(name = "BOOK_SEQ", sequenceName = "BOOK_SEQ")
	private Long bookId;

	private String bookName;

	private Long price;
	

}
