/**
 * 
 */
/**
 * @author vishal
 *
 */
package com.insert.table.db.collegeBean;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.insert.table.db.student.Student;

import lombok.Data;
@Data
@Entity
@Table(name="college1")
public class College 
{
	@Id
	@GeneratedValue
	private Long cid;
	private String cname;
	private String cdep;
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "college")
	private  List<Student> student;
	
	public College()
	{
		
	}
}
