package com.prototype.pillbox.classes;

import java.util.ArrayList;
import java.util.Date;

import android.text.format.Time;

public class POJOschedule {
	
	int user_id;
	boolean Active;
	int refill_reminder;
	String color;
	ArrayList<String> days;
	int frequency;
	Date start_date;
	Date end_date;
	int interval;
	Time start_time;
	public synchronized int getUser_id() {
		return user_id;
	}
	public synchronized void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public synchronized boolean isActive() {
		return Active;
	}
	public synchronized void setActive(boolean active) {
		Active = active;
	}
	public synchronized int getRefill_reminder() {
		return refill_reminder;
	}
	public synchronized void setRefill_reminder(int refill_reminder) {
		this.refill_reminder = refill_reminder;
	}
	public synchronized String getColor() {
		return color;
	}
	public synchronized void setColor(String color) {
		this.color = color;
	}
	public synchronized ArrayList<String> getDays() {
		return days;
	}
	public synchronized void setDays(ArrayList<String> days) {
		this.days = days;
	}
	public synchronized int getFrequency() {
		return frequency;
	}
	public synchronized void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public synchronized Date getStart_date() {
		return start_date;
	}
	public synchronized void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public synchronized Date getEnd_date() {
		return end_date;
	}
	public synchronized void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public synchronized int getInterval() {
		return interval;
	}
	public synchronized void setInterval(int interval) {
		this.interval = interval;
	}
	public synchronized Time getStart_time() {
		return start_time;
	}
	public synchronized void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

}
