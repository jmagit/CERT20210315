package com.examples.types;

public enum Days {
	SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

	private int numericValue;

	Days(int value) {
		numericValue = value;
	}

	public int getValue() {
		return numericValue;
	}

	public static Days getEnum(int value) {
		switch (value) {
		case 1:
			return SUNDAY;
		case 2:
			return MONDAY;
		case 3:
			return TUESDAY;
		case 4:
			return WEDNESDAY;
		case 5:
			return THURSDAY;
		case 6:
			return FRIDAY;
		case 7:
			return SATURDAY;
		default:
			throw new IllegalArgumentException("Unexpected value: " + value);
		}
	}

}
