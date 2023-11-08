package com.sanjeev.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "employee_table")
public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	    @SequenceGenerator(initialValue = 1, name = "emp_seq", sequenceName = "employee_sequence")
	    @Column(name = "id")
	    private Integer id;
	    @Column(name = "name")
	    private String name;
	    @Column(name = "city")
	    private String city;
	    
	    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	    @JoinColumn(foreignKey = @ForeignKey(name = "dept_id"), name = "dept_id")
	    private Department department;

}
