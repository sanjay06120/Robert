package com.ioco.Entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Survivours")
public class Survivors implements Serializable{
	private static final long serialVersionUID  = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="survivours_id")
	private Long SId;
	
	@Column(name="survivours_name")
	private String SName;
	
	@Column(name="age")
	private int age;
	
	@Enumerated(EnumType.STRING)
    private Gender gender;
 
	@Column(name="location")
	private String location;
	
	@Column(name="longtitude")
	private String longtitude;
	
	@Column(name="latitude")
	private String latitude;
	
	
	@Column(name="isInfected")
	private Boolean flag;

	public Survivors(){
		
	}
	public Long getSId() {
		return SId;
	}

	public void setSId(Long sId) {
		SId = sId;
	}

	public String getSName() {
		return SName;
	}

	public void setSName(String sName) {
		SName = sName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Survivours [SId=" + SId + ", SName=" + SName + ", age=" + age + ", location=" + location
				+ ", longtitude=" + longtitude + ", latitude=" + latitude + ", flag=" + flag + "]";
	} 
	
	
	
 
}
