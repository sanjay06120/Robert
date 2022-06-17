package com.ioco.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Robert")
public class Robert implements Serializable {
	private static final long serialVersionUID  = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="model")
	private String model;
	
	@Column(name="serial_Number")
	private String serial_Number;
	
	
	@Column(name="date")
	private Date date;
	
	@Enumerated(EnumType.STRING)
    private Category category;
	
	public Robert() {
		// TODO Auto-generated constructor stub
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerial_Number() {
		return serial_Number;
	}

	public void setSerial_Number(String serial_Number) {
		this.serial_Number = serial_Number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Robert [model=" + model + ", serial_Number=" + serial_Number + ", date=" + date + ", category="
				+ category + "]";
	}

	
}
