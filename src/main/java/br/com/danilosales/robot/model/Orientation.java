package br.com.danilosales.robot.model;

import java.util.Arrays;

public enum Orientation {

	NORTH("N", 0),
	EAST("E", 90),
	SOUTH("S", 180),
	WEST("W", 270);
	
	private String symbol;
	
	private int value;
	
	Orientation(String symbol, int value) {
		this.symbol = symbol;
		this.value = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getValue() {
		return value;
	}
	
	public static Orientation getByValue(int value) {
		return Arrays.stream(values())
				.filter(item -> item.value == value).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
	
	
	public static Orientation getBySymbol(String symbol) {
		return Arrays.stream(values())
				.filter(item -> item.symbol.equals(symbol.toUpperCase())).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
	
}
