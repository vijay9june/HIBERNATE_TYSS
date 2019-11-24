package com.tyss.jpawithhibernateapp.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="pencil")
@Data
public class Pencil {
	@Id
	@Column
	private int pid;
	@Column
	private String color;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bid" ,nullable =false)
	private PencilBox pencilBox;
}






