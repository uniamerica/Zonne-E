package br.com.zonne.api.controllers;

import br.com.zonne.api.models.StreetModel;
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
public class StreetControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private StreetController street;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(street).build();
    }

    @Test
    @DisplayName("Retornar status code 201 quando criar street com dados corretos")
    public void shouldReturnStatusCode201_WhenCreateStreetWithCorrectData() throws Exception {
        StreetModel street = new StreetModel(1L, "streetTest");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(street);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/street")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Retorna status code 400 quando criar street com dados incorretos")
    public void shouldReturnStatusCode400_WhenCreateStreetWithIncorrectData() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/street")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Retorna status com 200 quando buscar streetName existente")
    public void shouldReturnStatusCode200_WhenSearchExistingStreetName() throws Exception {
        StreetModel street = new StreetModel(2L,"streetTest1");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(street);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/street")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/street/2"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Retornar status code 404 quando buscar StreetName inexistente")
    public void shouldReturnStatusCode404_WhenSearchUnexistingStreetName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/street/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Retornar status code 200 quando deletar StreetName")
    public void shouldReturnStatusCode200_WhenDeleteExistingStreetName() throws Exception {
        StreetModel street = new StreetModel(1L,"streetTest");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(street);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/street")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/street/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Retornar status code 404 quando deletar streetName inexistente")
    public void shouldReturnStatusCode404_WhenDeleteUnexistingStreet() throws  Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/street/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}