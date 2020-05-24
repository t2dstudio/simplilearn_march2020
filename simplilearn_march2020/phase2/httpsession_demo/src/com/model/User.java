package com.model;

public class User {

	private int id;
	private String fname;
	private String city;
	private String contact;
	private String email;
	private String qualification;
	private int year;
	private String collage;
	private String certificationName;
	private int yearOfCertification;
	private int validity;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCollage() {
		return collage;
	}

	public void setCollage(String collage) {
		this.collage = collage;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public int getYearOfCertification() {
		return yearOfCertification;
	}

	public void setYearOfCertification(int yearOfCertification) {
		this.yearOfCertification = yearOfCertification;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	@Override
	public String toString() {
		return "User [id=" + email.hashCode() + ", fname=" + fname + ", city=" + city + ", contact=" + contact + ", email=" + email
				+ ", qualification=" + qualification + ", year=" + year + ", collage=" + collage
				+ ", certificationName=" + certificationName + ", yearOfCertification=" + yearOfCertification
				+ ", validity=" + validity + "]";
	}
	
	
}
