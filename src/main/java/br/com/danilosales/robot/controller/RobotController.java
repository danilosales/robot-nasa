package br.com.danilosales.robot.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danilosales.robot.service.RobotService;

@RestController
@RequestMapping("/rest/mars")
public class RobotController {

	@Autowired
	private RobotService robotService;
	
	@RequestMapping("/{instruction}")
	public String moveRobot(@NotNull @PathVariable("instruction")String instruction) {
		return robotService.executeInstructions(instruction);
	}
}
