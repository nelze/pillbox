package com.prototype.pillbox.classes;
public class MedicineInfo {
public String name;
public String dosage;
public String status;
public String schedule;
public String tabletsRem;

public MedicineInfo(String name, String dosage, String status, String schedule, String tabletsRem) {
this.name = name;
this.dosage = dosage;
this.status = status;
this.schedule = schedule;
this.tabletsRem = tabletsRem;

}

public synchronized String getName() {
	return name;
}

public synchronized void setName(String name) {
	this.name = name;
}

public synchronized String getDosage() {
	return dosage;
}

public synchronized void setDosage(String dosage) {
	this.dosage = dosage;
}

public synchronized String getStatus() {
	return status;
}

public synchronized void setStatus(String status) {
	this.status = status;
}

public synchronized String getSchedule() {
	return schedule;
}

public synchronized void setSchedule(String schedule) {
	this.schedule = schedule;
}

public synchronized String getTabletsRem() {
	return tabletsRem;
}

public synchronized void setTabletsRem(String tabletsRem) {
	this.tabletsRem = tabletsRem;
}
}