package com.fssa.liveon.enums;

public enum GenderCategory {
	MALE("Male"), FEMALE("Female"),OTHERS("Others");

	private final String gender;

	public String getGender() {
		return gender;
	}

	private GenderCategory(String gender) {
		this.gender = gender;
	}
}
