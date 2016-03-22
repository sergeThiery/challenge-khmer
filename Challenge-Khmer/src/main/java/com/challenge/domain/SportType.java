package com.challenge.domain;

public enum SportType {

	FOOTBALL("football"), HANDBALL("handball"), BASKETBALL("basketball");

	private String code;

	private SportType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static SportType getSport(String code) {

		if (code.toLowerCase().equals("football")) {
			return FOOTBALL;
		} else if (code.toLowerCase().equals("handball")) {
			return HANDBALL;
		} else if (code.toLowerCase().equals("basketball")) {
			return BASKETBALL;
		} else {
			return null;
		}

	}

}
