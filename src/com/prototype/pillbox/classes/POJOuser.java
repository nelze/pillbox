package com.prototype.pillbox.classes;

import java.util.Date;

public class POJOuser {
	
	String First_name;
	String Last_name;
	String Email;
	String Password;
	Date Bday;
	String Gender;
	public synchronized String getFirst_name() {
		return First_name;
	}
	public synchronized void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public synchronized String getLast_name() {
		return Last_name;
	}
	public synchronized void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public synchronized String getEmail() {
		return Email;
	}
	public synchronized void setEmail(String email) {
		Email = email;
	}
	public synchronized String getPassword() {
		return Password;
	}
	public synchronized void setPassword(String password) {
		Password = password;
	}
	public synchronized Date getBday() {
		return Bday;
	}
	public synchronized void setBday(Date bday) {
		Bday = bday;
	}
	public synchronized String getGender() {
		return Gender;
	}
	public synchronized void setGender(String gender) {
		Gender = gender;
	}

}
