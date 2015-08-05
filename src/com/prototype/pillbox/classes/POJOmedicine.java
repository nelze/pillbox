package com.prototype.pillbox.classes;

public class POJOmedicine {
	
	String Name;
	int Dosage;
	int Stock;
	int Schedule_Id;
	public synchronized String getName() {
		return Name;
	}
	public synchronized void setName(String name) {
		Name = name;
	}
	public synchronized int getDosage() {
		return Dosage;
	}
	public synchronized void setDosage(int dosage) {
		Dosage = dosage;
	}
	public synchronized int getStock() {
		return Stock;
	}
	public synchronized void setStock(int stock) {
		Stock = stock;
	}
	public synchronized int getSchedule_Id() {
		return Schedule_Id;
	}
	public synchronized void setSchedule_Id(int schedule_Id) {
		Schedule_Id = schedule_Id;
	}

}
