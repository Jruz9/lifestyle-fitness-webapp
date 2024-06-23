//package com.webapp.lifestylefitnesswebapp.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.webapp.lifestylefitnesswebapp.entities.Exercise;
//import com.webapp.lifestylefitnesswebapp.services.ExerciseService;
//import org.assertj.core.util.Lists;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.doReturn;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
//import static org.mockito.ArgumentMatchers.any;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ExerciseControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ExerciseService exerciseService;
//
//
//
//
//
////test works, use this as a template for other test for your variables
//    @Test
//    @DisplayName("GET /exercise get all success")
//    public void testGetResponse() throws Exception{
//        Exercise exercise1 = new Exercise(1L,"pull ups",5,4,0.0,5,"strength");
//        doReturn(Lists.newArrayList(exercise1)).when(exerciseService).getAllExercise();
//
//        mockMvc.perform(get("/api/v1/exercise")).andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//
//                .andExpect(jsonPath("$[0].exerciseId").isNotEmpty())
//                .andExpect(jsonPath("$[0].reps", is(5)))
//                .andExpect(jsonPath("$[0].sets",is(5)))
//                .andExpect(jsonPath("$[0].speed", is(0.0)))
//                .andExpect(jsonPath("$[0].time", is(4)))
//                .andExpect(jsonPath("$[0].exerciseForm",is("strength")));
//    }
//
//    @Test
//    @DisplayName("GET /api/v1/exercise/{id}")
//    public void TestGetExerciseById() throws Exception{
//        Exercise exercise1 = new Exercise(1L,"pull ups",5,4,0.0,5,"strength");
//        doReturn(Optional.of(exercise1)).when(exerciseService).findByExerciseId(1L);
//
//        //Validates response code and content type
//        mockMvc.perform(get("/api/v1/exercise/{exerciseId}",1L))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//
////                .andExpect(header().string(HttpHeaders.LOCATION,"/api/v1/exercise/1"))
////                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
//
//                //validate  the returning fields
//                .andExpect(jsonPath("$.exerciseId").value(1))
//                .andExpect(jsonPath("$.reps").value(5))
//
//                .andExpect(jsonPath("$.sets").value(5))
//
//                .andExpect(jsonPath("$.speed").value(0.0))
//
//                .andExpect(jsonPath("$.time").value(4))
//
//                .andExpect(jsonPath("$.exerciseForm").value("strength"));
//
//    }
//
//
//
//
//    @Test
//    @DisplayName("GET /exercise/1 - NOT FOUND")
//    public void testGetExerciseByIdNotFound() throws Exception{
//        //set up mocked services
//
//        doReturn(Optional.empty()).when(exerciseService).findByExerciseId(1L);
//
//        //execute get request
//        mockMvc.perform(get("/api/v1/exercise/{exerciseId}",1L)).andExpect(status().isNotFound());
//    }
//
//
//    @Test
//    @DisplayName("PUT /api/v1/exercise/1 ")
//    public void updateExerciseTest() throws Exception{
//        Exercise exercise1 = new Exercise();
//        Exercise exercise2 = new Exercise(1L,"pull ups",5,4,0.0,5,"strength");
//        Exercise exercise3 = new Exercise(1L,"pull ups",5,4,0.0,5,"aerobic");
//        doReturn(Optional.of(exercise2)).when(exerciseService).findByExerciseId(1L);
//        doReturn(exercise3).when(exerciseService).saveExercise(any());
//
//        mockMvc.perform(put("/api/v1/exercise/{exerciseId}",1L)
//        .contentType(MediaType.APPLICATION_JSON)
//                .header(HttpHeaders.IF_MATCH,"strength")
//        .content(asJsonString(exercise1)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//
//                .andExpect(jsonPath("$.exerciseId").value(1))
//                .andExpect(jsonPath("$.sets").value(5))
//                .andExpect(jsonPath("$.reps").value(5))
//                .andExpect(jsonPath("$.speed").value(0.0))
//                .andExpect(jsonPath("$.time").value(4))
//                .andExpect(jsonPath("$.exerciseForm").value("aerobic"));
//    }
//
//
//    @Test
//    @DisplayName("POST api/v1/exercise")
//    public void testAddExercise() throws Exception{
//        Exercise exercise1 = new Exercise();
//        Exercise exercise2 = new Exercise(1L,"pull ups",5,4,0.0,5,"strength");
//        doReturn(exercise2).when(exerciseService).saveExercise(any());
//
//        mockMvc.perform(post("/api/v1/exercise/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(exercise1)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//
//
//                .andExpect(jsonPath("$.exerciseId").value(1))
//                .andExpect(jsonPath("$.sets").value(5))
//                .andExpect(jsonPath("$.reps").value(5))
//                .andExpect(jsonPath("$.speed").value(0.0))
//                .andExpect(jsonPath("$.time").value(4))
//                .andExpect(jsonPath("$.exerciseForm").value("strength"));
//
//    }
//
//    static  String asJsonString(final Object obj){
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e){
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//}
