package br.com.zonne.api.services;

import br.com.zonne.api.models.UserModel;
import br.com.zonne.api.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestConfiguration{

        @Bean
        public UserService userService(){
            return new UserService();
        }
    }

    @Autowired
    UserService service;

    @MockBean
    UserRepository repository;

    @Test
    public void userServiceTestFindByCpf(){
        String cpf = "120.000.000-37";
        UserModel userTest = service.findByCpf(cpf);
        Assertions.assertEquals(userTest.getCpf(), cpf);
    }

    @Test
    public void userServiceTestInsertUser(){
        UserModel userTest = new UserModel("123.000", "John", "Doe", "email@email.com", "123");
        UserModel userInserted = service.insert(userTest);

        Assertions.assertEquals(userTest, userInserted);
        Assertions.assertNotNull(userInserted);

    }

    @Before
    public void setup(){
        UserModel user = new UserModel("120.000.000-37", "Pedro", "Silva", "test@hotmail.com", "123");

        Mockito.when(repository.findByCpf(user.getCpf())).thenReturn(java.util.Optional.of(user));
    }
}
