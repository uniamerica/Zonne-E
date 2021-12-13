package br.com.zonne.api.controllers;

import br.com.zonne.api.models.UserModel;
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
public class UserControllerTest{

    private MockMvc mockMvc;

    @Autowired
    private UserController controller;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Deve retornar status code 201 quando criar usuario com dados corretos")
    public void shouldReturnStatusCode201_WhenCreateUserWithCorrectData() throws Exception {
        UserModel user = new UserModel("12006934937", "John", "Doe", "email@email.com", "1234", null);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Deve retornar status code 400 quando criar usuario com dados incorretos")
    public void shouldReturnStatusCode400_WhenCreateUserWithIncorrectData() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar status code 422 quando criar usuario com CPF incorreto")
    public void shouldReturnStatusCode422_WhenCreateUserWithIncorrectCpf() throws Exception {
        UserModel user = new UserModel("123", "John", "Doe", "email@email.com", "1234", null);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    @DisplayName("Deve retornar status code 422 quando criar usuario com CPF existente")
    public void shouldReturnStatusCode422_WhenCreateUserWithExistingCpf() throws Exception {
        UserModel existingUser = new UserModel("12006934937", "John", "Doe", "email@email.com", "1234", null);
        UserModel user = new UserModel("12006934937", "Test", "Test2", "email@email.com", "12345", null);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(existingUser);
        String json2 = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    @DisplayName("Deve retornar status code 200 quando buscar usuario existente")
    public void shouldReturnStatusCode200_WhenSearchExistingUser() throws Exception {
        UserModel user = new UserModel("12006934937", "John", "Doe", "email@email.com", "1234", null);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/12006934937"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Deve retornar status code 404 quando buscar usuario inexistente")
    public void shouldReturnStatusCode400_WhenSearchUnexistingUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/12006934937"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    @DisplayName("Deve retornar status code 200 quando deletar usuario existente")
    public void shouldReturnStatusCode200_WhenDeleteExistingUser() throws Exception {
        UserModel user = new UserModel("12006934937", "John", "Doe", "email@email.com", "1234", null);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/user/12006934937"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Deve retornar status code 404 quando deletar usuario inexistente")
    public void shouldReturnStatusCode404_WhenDeleteUnexistingUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/user/12006934937"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
