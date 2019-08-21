package br.com.danilosales.robot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RobotControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void invalidCommand() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/AAA")
			.accept(MediaType.TEXT_PLAIN)
			.contentType(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.status().isBadRequest())
			.andReturn();
		
	}
	
	@Test
	public void invalidPosition() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM")
			.accept(MediaType.TEXT_PLAIN)
			.contentType(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.status().isBadRequest())
			.andReturn();
		
	}
	
	@Test
	public void rightRotationsMove() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/MMRMMRMM")
			.accept(MediaType.TEXT_PLAIN)
			.contentType(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("(2,0,S)"))
			.andReturn();
	}
	
	@Test
	public void leftRotationMove() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/MML")
			.accept(MediaType.TEXT_PLAIN)
			.contentType(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("(0,2,W)"))
			.andReturn();
	}
	
	@Test
	public void repeatLeftRotationMove() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/MML")
			.accept(MediaType.TEXT_PLAIN)
			.contentType(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("(0,2,W)"))
			.andReturn();
	}
}
