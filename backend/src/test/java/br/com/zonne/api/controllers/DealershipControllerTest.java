package br.com.zonne.api.controllers;

import br.com.zonne.api.models.DealershipModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DealershipControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private DealershipController controller;

    @BeforeEach
    public void setup() { this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); }

    @Test
    @DisplayName("Retornar status code 201 quando criar dealership com dados corretos")
    public void shouldReturnStatusCode201_WhenCreateDealershipWithCorrectData() throws Exception {
        DealershipModel dealership = new DealershipModel(1L,"dealershipTest1");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(dealership);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/dealership")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Retorna status code 400 quando criar dealership com dados incorretos")
    public void shouldReturnStatusCode400_WhenCreateDealershipWithIncorrectData() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/dealership")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Retorna status code 422 quando cirar Dealership com dealershipName incorreto")
    public void shouldReturnStatusCode422_WhenCreateDealershipWithIncorrectDealershipName() throws Exception {
        DealershipModel dealership = new DealershipModel(1L,null);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(dealership);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/dealership")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    @DisplayName("Retorna status code 422 quando criar dealership com dealershipName existente")
    public void shouldReturnStatusCode422_WhenCreateUserWithExistingDealershipName() throws Exception {
        DealershipModel existingDealership = new DealershipModel(1L,"dealershipTest");
        DealershipModel dealership = new DealershipModel(1L,"dealershipTest1");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(existingDealership);
        String json2 = mapper.writeValueAsString(dealership);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/dealership")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/dealership")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    @DisplayName("Retorna status com 200 quando buscar dealershipName existente")
    public void shouldReturnStatusCode200_WhenSearchExistingDealershipName() throws Exception {
        DealershipModel dealership = new DealershipModel(1L,"dealershipTest");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(dealership);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/dealership")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/dealership/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Retornar status code 404 quando buscar dealershipName inexistente")
    public void shouldReturnStatusCode400_WhenSearchUnexistingDealershipName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/dealership/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    @DisplayName("Retornar status code 200 quando deletar dealershipName")
    public void shouldReturnStatusCode200_WhenDeleteExistingDealershipName() throws Exception {
        DealershipModel dealership = new DealershipModel(1L,"dealershipTest");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(dealership);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/dealership")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/dealership/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Retornar status code 404 quando deletar dealershipName inexistente")
    public void shouldReturnStatusCode404_WhenDeleteUnexistingDealershipName() throws  Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/dealership/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
