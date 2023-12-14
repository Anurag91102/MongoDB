package com.mongo.model;

import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Address {
	
	@Id
	private int aid;
	
	private String lane;
	
	private String area;
	
	private String state;

	@JsonIgnore
	private Student student;

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", lane=" + lane + ", area=" + area + ", state=" + state + ", student=" + student
				+ "]";
	}

	public Address(int aid, String lane, String area, String state, Student student) {
		super();
		this.aid = aid;
		this.lane = lane;
		this.area = area;
		this.state = state;
		this.student = student;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
