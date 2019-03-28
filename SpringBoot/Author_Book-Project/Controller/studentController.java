package com.insert.table.db.model;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.insert.table.db.collegeBean.College;
import com.insert.table.db.collegeRepository.CollegeRepository;
import com.insert.table.db.student.Student;
import com.insert.table.db.studentRepository.StudentRepository;
/**
 * @author vishal
 *
 */
@RestController
@RequestMapping
public class StudentModel {
	@Autowired
	StudentRepository studentR;
	
	@Autowired
	CollegeRepository collegeR;
	
	 @GetMapping("/show/{cid}")
	    public Iterable<Student> getAll() {
	        return studentR.findAll();
	    }
	 
	 @GetMapping("/get/{cid}")
	    public Optional<College> getAllCommentsByPostId(@PathVariable (value = "cid") Long cid,College college) {
	        return collegeR.findById(cid);
	    }

	    @PostMapping("/college1/{cid}")
	    public Student getStudent(@PathVariable (value="cid") Long cid , @Valid @RequestBody Student student) {
	    	
	        return collegeR.findById(cid).map(college -> {
	            student.setCollege(college);
	            return studentR.save(student);
	        }).orElseThrow(() -> new ResourceAccessException("College_id " + cid + " not found"));
	    }
	    
	  //Delete all records From Student
		@GetMapping(value="/del")
		public void  delete()
		{
			studentR.deleteAll();
		}
	
	/*
	
	//Show Table Record
	@GetMapping(value="/showStudent")
	public Iterable<Student> getAll()
	{
		return studentR.findAll();
	}
	
	//Insert Into table
	@PostMapping(value="/insetStudent")
	public Iterable<Student> getAllStudent(@RequestBody final Student student)
	{
		studentR.save(student);
		return studentR.findAll(); 
	}
	
	//Delete specific Records in student
	@GetMapping(value="/deleteStudent/{sid}")
	public void delete(@PathVariable("sid") Integer sid)
	{
		studentR.deleteById(sid); 	
	}
	
	//Delete all records From Student
	@GetMapping(value="/del")
	public void  delete()
	{
		studentR.deleteAll();
	}
	
	//Search Data From Table Student
	@GetMapping("/search/{sid}")
	public Optional<Student> getStudent(@PathVariable("sid") Integer sid) {
		return studentR.findById(sid);
	}
	
	
	//Update Table Student
	@PutMapping(value="/update/{sid}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable("sid") Integer sid) {
		Optional<Student> st= studentR.findById(sid);

		if (!st.isPresent())
			return ResponseEntity.notFound().build();
		student.setSid(sid);
		studentR.save(student);
		return ResponseEntity.noContent().build();

		}
	*/
	
	

}
