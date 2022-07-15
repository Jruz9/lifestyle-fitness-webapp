package com.webapp.lifestylefitnesswebapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.lifestylefitnesswebapp.entities.Food;
import com.webapp.lifestylefitnesswebapp.services.FoodService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
public class FoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodService foodService;


    @Test
    @DisplayName("GET /exercise get all success")
    public void TestGetAllResponse() throws Exception{
        Food food1= new Food(1L,"ice cream",200.0,10.0,8.0,12.0,5.0,"snack");

        doReturn(Lists.newArrayList(food1)).when(foodService).getAllFood();

        mockMvc.perform(get("/api/v1/foods"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())

                .andExpect(jsonPath("$[0].foodId").isNotEmpty())
                .andExpect(jsonPath("$[0].foodName").value("ice cream"))
                .andExpect(jsonPath("$[0].calorie").value(200.0))
                .andExpect(jsonPath("$[0].protein").value(10.0))
                .andExpect(jsonPath("$[0].carbs").value(8.0))
                .andExpect(jsonPath("$[0].sugar").value(12.0))
                .andExpect(jsonPath("$[0].fat").value(5.0))
                .andExpect(jsonPath("$[0].foodTime").value("snack"));

    }
    @Test
    @DisplayName("Get api/v1/foods/{food_id}")
    public void testGetFoodById()throws Exception{
        Food food1= new Food(1L,"ice cream",200.0,10.0,8.0,12.0,5.0,"snack");
        doReturn(Optional.of(food1)).when(foodService).findByFoodId(1L);

        mockMvc.perform(get("/api/v1/foods/{foodId}",1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.foodId").isNotEmpty())
                .andExpect(jsonPath("$.foodName").value("ice cream"))
                .andExpect(jsonPath("$.calorie").value(200.0))
                .andExpect(jsonPath("$.protein").value(10.0))
                .andExpect(jsonPath("$.carbs").value(8.0))
                .andExpect(jsonPath("$.sugar").value(12.0))
                .andExpect(jsonPath("$.fat").value(5.0))
                .andExpect(jsonPath("$.foodTime").value("snack"));

    }
    @Test
    public void testGetFoodByIdNotFound() throws Exception{
        doReturn(Optional.empty()).when(foodService).findByFoodId(1L);

        mockMvc.perform(get("/api/v1/foods/{foodId}",1L)).andExpect(status().isNotFound());

    }
    @Test
    @DisplayName("PUT /api/v1/foods/1")
    public void testUpdateFood() throws Exception{
        Food food1= new Food();
        Food food2=new Food(1L,"ice cream",200.0,10.0,8.0,12.0,5.0,"snack");
        Food food3=new Food(1L,"ice cream",200.0,10.0,8.0,12.0,5.0,"dinner");

        doReturn(Optional.of(food2)).when(foodService).findByFoodId(1L);
        //reason for this method was used in the updateFood put in the controller
        doReturn(food3).when(foodService).updateFoodInformation(any());

        mockMvc.perform(put("/api/v1/foods/{foodId}",1L)
        .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.IF_MATCH,"snack")
        .content(asJsonString(food1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.foodId").value(1))
                .andExpect(jsonPath("$.foodName").value("ice cream"))
                .andExpect(jsonPath("$.calorie").value(200.0))
                .andExpect(jsonPath("$.protein").value(10.0))
                .andExpect(jsonPath("$.carbs").value(8.0))
                .andExpect(jsonPath("$.sugar").value(12.0))
                .andExpect(jsonPath("$.fat").value(5.0))
                .andExpect(jsonPath("$.foodTime").value("dinner"));
    }

    @Test
    @DisplayName("POST api/v1/foods")
    public void testCreateFood() throws Exception{
        Food food1= new Food();
        Food food2=new Food(1L,"ice cream",200.0,10.0,8.0,12.0,5.0,"snack");
        doReturn(food2).when(foodService).saveFood(any());

        mockMvc.perform(post("/api/v1/foods")
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(food1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.foodId").value(1))
                .andExpect(jsonPath("$.foodName").value("ice cream"))
                .andExpect(jsonPath("$.calorie").value(200.0))
                .andExpect(jsonPath("$.protein").value(10.0))
                .andExpect(jsonPath("$.carbs").value(8.0))
                .andExpect(jsonPath("$.sugar").value(12.0))
                .andExpect(jsonPath("$.fat").value(5.0))
                .andExpect(jsonPath("$.foodTime").value("snack"));

    }


    static  String asJsonString(final Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }


    }
}
