package br.com.zonne.api.services;

import br.com.zonne.api.exceptions.CpfInvalidException;
import br.com.zonne.api.exceptions.UserAlreadyExistsException;
import br.com.zonne.api.exceptions.UserNotFoundException;
import br.com.zonne.api.models.DistrictModel;
import br.com.zonne.api.models.UserModel;
import br.com.zonne.api.repositories.UserRepository;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

//    @TestConfiguration
//    static class UserServiceTestConfiguration{
//
//        @Bean
//        public UserService userService(){
//            return new UserService();
//        }
//    }

    @Autowired
    UserService service;


    @MockBean
    UserRepository repository;

    @Test
    @DisplayName("Deve retornar sucesso quando buscar um usuario")
    public void shouldReturnSuccess_WhenFindUser(){
        String cpf = "12006934937";
        UserModel userTest = service.findByCpf(cpf);
        Assertions.assertEquals(userTest.getCpf(), cpf);
    }

    @Test
    @DisplayName("Deve retornar não encontrado quando buscar um usuario")
    public void shouldReturnNotFound_WhenFindUser(){
        String cpf = "32220765962";
        Assertions.assertThrows(UserNotFoundException.class, () -> service.findByCpf(cpf) );
    }


//    @Test
//    public void userServiceTestEdit(){
//        UserModel userTest = service.findByCpf("12006934937");
//        UserModel userToCompare = new UserModel("12006934937", "John", "Doe", "email@email.com", "1234",null);
//        userTest.setUserName("Jon");
//        userTest.setUserPassword("12345");
//
//        service.edit("12006934937", userTest);
//
//        UserModel userEdit = new UserModel();
//
//        userEdit.setCpf(userTest.getCpf());
//        userEdit.setUserName(userTest.getUserName());
//        userEdit.setUserLastName(userTest.getUserLastName());
//        userEdit.setUserEmail(userTest.getUserEmail());
//        userEdit.setUserPassword(userTest.getUserPassword());
//
//        Assertions.assertEquals(userTest, userEdit);
//        Assertions.assertNotEquals(userToCompare, userEdit);
//
//        System.out.println(" " + userEdit.getCpf() + " " + userEdit.getUserName() + " " + userEdit.getUserLastName() + " " + userEdit.getUserEmail() + " " + userEdit.getUserPassword());
//        System.out.println(" " + userToCompare.getCpf() + " " + userToCompare.getUserName() + " " + userToCompare.getUserLastName() + " " + userToCompare.getUserEmail() + " " + userToCompare.getUserPassword());
//    }

    @Test
    @DisplayName("Deve retornar cpf invalido quando inserir usuario")
    public void shouldReturnCpfInvalid_WhenInsideUser(){
        UserModel userTest = new UserModel("1523", "Nome", "sobreNome", "teste@teste.com", "1234", null);
        Assertions.assertThrows(CpfInvalidException.class, () -> service.insert(userTest) );
    }

    @Test
    @DisplayName("Deve retornar sucesso quando inserir usuario")
    public void shouldReturnSuccess_WhenInsideUser(){
        UserModel userTest = new UserModel("32220765962", "Nome", "sobreNome", "@.com", "1234", null);
        Assertions.assertDoesNotThrow(() -> service.insert(userTest) );
    }

    @Test
    @DisplayName("Deve retornar uma exception quando inserir usuario existente")
    public void shouldReturnException_WhenInsideExistentUser(){
        UserModel userTest = new UserModel("12006934937", "Nome", "sobreNome", "@.com", "1234", null);
        Assertions.assertThrows(UserAlreadyExistsException.class, () -> service.insert(userTest) );
    }

    @BeforeEach
    public void setup(){
        UserModel user = new UserModel("12006934937", "John", "Doe", "email@email.com", "1234", null);
        Mockito.when(repository.findByCpf(user.getCpf())).thenReturn(java.util.Optional.of(user));
    }
}
