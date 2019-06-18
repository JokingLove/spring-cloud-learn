package com.ikang.springbootcxfservice.dto;

public enum Sex {

	MALE("male"),
	FEMALE("female");

	String value;

	Sex(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}

	public static Sex fromValue(String v) {
		for(Sex s : Sex.values()) {
			if(s.value.equals(v)) {
				return s;
			}
		}

		throw new IllegalArgumentException(v);
	}
}
