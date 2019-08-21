package br.com.danilosales.robot.model;

import java.util.Arrays;

public enum Rotation {

	LEFT("L",-90),
    RIGHT("R",90);
	
	private final String symbol;
    
	private final int value;
	
	Rotation(String symbol, int value) {
		this.symbol = symbol;
		this.value = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getValue() {
		return value;
	}
	
	
	public static Rotation getByValue(int value) {
		return Arrays.stream(values())
				.filter(item -> item.value == value).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
	
	
	public static Rotation getBySymbol(String symbol) {
		return Arrays.stream(values())
				.filter(item -> item.symbol.equals(symbol.toUpperCase())).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
	
}
