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
        String cpf = "12006934937";
        UserModel userTest = service.findByCpf(cpf);
        Assertions.assertEquals(userTest.getCpf(), cpf);
    }

    @Test
    public void userServiceTestInsertUser(){
        UserModel userTest = new UserModel("12006934937", "John", "Doe", "email@email.com", "1234");
        Mockito.when(repository.save(userTest)).thenReturn(userTest);
        UserModel userInserted = service.findByCpf("12006934937");

        Assertions.assertEquals(userTest, userInserted);
        Assertions.assertNotNull(userInserted);
        System.out.println(userInserted);

    }

    @Test
    public void userServiceTestEdit(){
        UserModel userTest = service.findByCpf("12006934937");
        UserModel userToCompare = new UserModel("12006934937", "John", "Doe", "email@email.com", "1234");

        userTest.setUserName("Jon");
        userTest.setUserPassword("12345");

        service.edit("12006934937", userTest);

        UserModel userEdit = new UserModel();

        userEdit.setCpf(userTest.getCpf());
        userEdit.setUserName(userTest.getUserName());
        userEdit.setUserLastName(userTest.getUserLastName());
        userEdit.setUserEmail(userTest.getUserEmail());
        userEdit.setUserPassword(userTest.getUserPassword());

        Assertions.assertEquals(userTest, userEdit);
        Assertions.assertNotEquals(userToCompare, userEdit);

        System.out.println(" " + userEdit.getCpf() + " " + userEdit.getUserName() + " " + userEdit.getUserLastName() + " " + userEdit.getUserEmail() + " " + userEdit.getUserPassword());
        System.out.println(" " + userToCompare.getCpf() + " " + userToCompare.getUserName() + " " + userToCompare.getUserLastName() + " " + userToCompare.getUserEmail() + " " + userToCompare.getUserPassword());
    }

    @Before
    public void setup(){
        UserModel user = new UserModel("12006934937", "John", "Doe", "email@email.com", "1234");

        Mockito.when(repository.findByCpf(user.getCpf())).thenReturn(java.util.Optional.of(user));

    }
}
