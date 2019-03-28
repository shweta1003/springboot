package com.insert.table.db.student;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insert.table.db.collegeBean.College;

import lombok.Data;


@Data
@Entity
@Table(name="student1")
public class Student {
	@Id
	@GeneratedValue
	private Long sid;
	private String sname;
	private String sbranch;
	private int smarks;
	//private int register_id;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "cid", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	private College college;
	
	public Student() {

	}
}
