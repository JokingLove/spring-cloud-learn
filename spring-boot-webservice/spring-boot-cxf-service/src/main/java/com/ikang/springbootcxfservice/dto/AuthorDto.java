package com.ikang.springbootcxfservice.dto;

import java.util.List;

public class AuthorDto {

	String name;

	List<String> hobby;

	String birthday;

	String description;

	Sex sex;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	@Override public String toString() {
		return "AuthorDto{" + "name='" + name + '\'' + ", hobby=" + hobby + ", birthday='" + birthday + '\'' + ", description='" + description + '\'' + ", sex=" + sex + '}';
	}
}
