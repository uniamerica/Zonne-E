package br.com.zonne.api.controllers;

import br.com.zonne.api.models.DistrictModel;
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
public class DistrictControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private DistrictController district;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(district).build();
    }

    @Test
    @DisplayName("Retornar status code 201 quando criar district com dados corretos")
    public void shouldReturnStatusCode201_WhenCreateDistrictWithCorrectData() throws Exception {
        DistrictModel district = new DistrictModel(1L, "districtTest");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(district);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/district")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Retorna status code 400 quando criar district com dados incorretos")
    public void shouldReturnStatusCode400_WhenCreateDistrictWithIncorrectData() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/district")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Retorna status com 200 quando buscar districtName existente")
    public void shouldReturnStatusCode200_WhenSearchExistingDistrictName() throws Exception {
        DistrictModel district = new DistrictModel(2L,"districtTest1");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(district);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/district")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/district/2"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Retornar status code 404 quando buscar DistrictName inexistente")
    public void shouldReturnStatusCode404_WhenSearchUnexistingDistrictName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/district/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Retornar status code 200 quando deletar DistrictName")
    public void shouldReturnStatusCode200_WhenDeleteExistingDistrictName() throws Exception {
        DistrictModel district = new DistrictModel(1L,"districtTest");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(district);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/district")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/district/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Retornar status code 404 quando deletar districtName inexistente")
    public void shouldReturnStatusCode404_WhenDeleteUnexistingStreet() throws  Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/district/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}