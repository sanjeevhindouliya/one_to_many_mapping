package com.sanjeev.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "Department")
public class Department {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "dept_seq")
	    @SequenceGenerator(initialValue = 1, name = "dept_seq", sequenceName = "dept_sequence")
	    @Column(name = "id")
	    private Integer id;
	    @Column(name = "deptName")
	    private String deptName;
	   
	    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonIgnore
	    private List<Employee> employees;
		
	    
	
}
