package br.com.danilosales.robot.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilosales.robot.model.Robot;
import br.com.danilosales.robot.model.Rotation;
import br.com.danilosales.robot.model.Terrain;

@Service
public class RobotService {

	@Autowired
	private Terrain terrain;

	@Autowired
	private Robot robot;
	
	private final String regexCommandsValid = "^[LRM]*";
	
	public String executeInstructions(String instruction) {
		
		if(!isCommandValid(instruction)) {
			throw new IllegalArgumentException("Comando inválido");
		}
		
		String[] commands = instruction.split("");
		
		Arrays.stream(commands).forEach(command -> {
			if(command.equals("M")) {
				robot.move();
			} else {
				robot.rotate(Rotation.getBySymbol(command));
			}
		});
		
		terrain.validateCoords(robot.getxCoord(), robot.getyCoord());
		
		return "(" + robot.getxCoord() + "," + robot.getyCoord() + "," 
			+ robot.getOrientation().getSymbol() + ")";
	}

	private boolean isCommandValid(String instruction) {
		return instruction.matches(regexCommandsValid);
		
	}
	
}
