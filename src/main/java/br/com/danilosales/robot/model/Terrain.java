package br.com.danilosales.robot.model;

import org.springframework.stereotype.Component;

@Component
public class Terrain {

	private int xAxis = 5;
	
	private int yAxis = 5;
	
	/**
	 * Define the size of terrain
	 * @param width 
	 * @param height
	 */
	public void setTerrain(int xAxisSize, int yAxisSize) {
		if(xAxisSize < 0 || yAxisSize < 0) {
			throw new IllegalArgumentException("Tamanho inválido do terreno");
		}
		this.xAxis = xAxisSize;
		this.yAxis = yAxisSize;
	}
	
	
	public void validateCoords(int x, int y) {
		if(x < 0 || x > xAxis || y < 0 || y > yAxis) {
			throw new IllegalArgumentException("Coordenadas inválidas");
		}
	}
	
}
