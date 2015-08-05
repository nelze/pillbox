package com.prototype.pillbox.classes;

import java.util.Date;
import java.util.List;

public class MedicinePOJO {
	
	private Long id;
	String name;
	int dosage;
	int stock;
	private Long schedule_id;
	List<SchedulePOJO> skedpojo;
	Date created_at;
	Date updated_at;
	String color;
	public List<SchedulePOJO> getSkedpojo() {
		return skedpojo;
	}
	public void setSkedpojo(SchedulePOJO skedpojo) {
		this.skedpojo.add(skedpojo);
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDosage() {
		return dosage;
	}
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Long getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(Long schedule_id) {
		this.schedule_id = schedule_id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}


}
