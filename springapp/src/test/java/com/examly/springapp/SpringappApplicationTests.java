package com.examly.springapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPostUser() throws Exception {
        String requestBody = "{\"id\": 1, \"username\": \"TestUser\", \"password\": \"TestPassword\", \"roles\": \"USER\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true))
                .andReturn();
    }

    @Test
    void testPostWorkout() throws Exception {
        String requestBody = "{\"id\": 1, \"user\": null, \"workoutType\": \"TestType\", \"duration\": \"TestDuration\", \"caloriesBurned\": \"TestCalories\", \"date\": \"2023-10-05T10:15:30\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/workout")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

	@Test
	void testGetUserById() throws Exception {
	
	
		mockMvc.perform(get("/user/1") // Specify the userId directly in the URL
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	void testGetAllWorkouts() throws Exception {
		mockMvc.perform(get("/workout")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();
	}
	

    @Test
    public void testControllerFolder() {
        String directoryPath = "src/main/java/com/examly/springapp/controller";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void testControllerFile() {
        String filePath = "src/main/java/com/examly/springapp/controller/ApiController.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testModelFolder() {
        String directoryPath = "src/main/java/com/examly/springapp/model";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void testModelFile() {
        String filePath = "src/main/java/com/examly/springapp/model/Workout.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testModelFile1() {
        String filePath = "src/main/java/com/examly/springapp/model/User.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testRepositoryFolder() {
        String directoryPath = "src/main/java/com/examly/springapp/repository";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void testRepositoryFile() {
        String filePath = "src/main/java/com/examly/springapp/repository/WorkoutRepo.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testRepositoryFile1() {
        String filePath = "src/main/java/com/examly/springapp/repository/UserRepo.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testServiceFolder() {
        String directoryPath = "src/main/java/com/examly/springapp/service";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void testServiceFile() {
        String filePath = "src/main/java/com/examly/springapp/service/UserService.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }
}
