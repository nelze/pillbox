package com.prototype.pillbox.classes;

public class POJOmedicine_taken {
	
	int Medicine_id;
	int Schedule_id;
	public synchronized int getMedicine_id() {
		return Medicine_id;
	}
	public synchronized void setMedicine_id(int medicine_id) {
		Medicine_id = medicine_id;
	}
	public synchronized int getSchedule_id() {
		return Schedule_id;
	}
	public synchronized void setSchedule_id(int schedule_id) {
		Schedule_id = schedule_id;
	}

}
