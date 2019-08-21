package br.com.danilosales.robot.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component()
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Robot {

	private int xCoord = 0;
	
	private int yCoord = 0;
	
	private Orientation orientation = Orientation.NORTH;

	public void rotate(Rotation rotation) {
		this.orientation = calculateRotation(rotation);
	}

	public void move() {
		switch(this.orientation) {
			case NORTH:
				this.yCoord++;
				break;
			case SOUTH:
				this.yCoord--;
				break;
			case EAST:
				this.xCoord++;
				break;
			case WEST:
				this.xCoord--;
				break;
		}
		
	}
	
	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public Orientation getOrientation() {
		return orientation;
	}
	
	private Orientation calculateRotation(Rotation rotation) {
		
		int rotationPositionValue = orientation.getValue() + rotation.getValue();
		
		if(rotationPositionValue < 0) {
			rotationPositionValue += 360;
		} else if(rotationPositionValue > 270) {
			rotationPositionValue -= 360;
		}
		
		return Orientation.getByValue(rotationPositionValue);
	}
	
}
