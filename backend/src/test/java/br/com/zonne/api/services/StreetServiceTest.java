package br.com.zonne.api.services;

import br.com.zonne.api.models.StreetModel;
import br.com.zonne.api.repositories.StreetRepository;


import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StreetServiceTest {


    @Autowired
    StreetService service;

    @MockBean
    StreetRepository repository;

    @Test
    public void StreetServiceTestFindById(){
        Long id = 1L;
        StreetModel streetTest = service.findById(id);
        Assertions.assertEquals(streetTest.getIdStreet(), id);
    }
    @Test
    public void streetServiceTestInsertStreet(){
        StreetModel streetTest = new StreetModel(1L, "streetTeste");
        Mockito.when(repository.save(streetTest)).thenReturn(streetTest);
        StreetModel streetInserted = service.findById(1L);

        Assertions.assertEquals(streetTest, streetInserted);
        Assertions.assertNotNull(streetInserted);
        System.out.println(streetInserted);

    }
    @Test
    public void streetServiceTestEdit(){
        StreetModel streetTestEdit = service.findById(1L);
        StreetModel streetToCompare = new StreetModel(1L,"streetTeste");

        streetTestEdit.setStreetName("streetTeste1");

        service.edit(1L, streetTestEdit);

        StreetModel streetEdit = new StreetModel();

        streetEdit.setIdStreet(streetTestEdit.getIdStreet());
        streetEdit.setStreetName(streetTestEdit.getStreetName());

        Assertions.assertEquals(streetTestEdit, streetEdit);
        Assertions.assertNotEquals(streetToCompare, streetEdit);

        System.out.println(" " + streetEdit.getIdStreet() + " " + streetEdit.getStreetName());
        System.out.println(" " + streetToCompare.getIdStreet() + " " + streetToCompare.getStreetName());
    }

    @Test
    @DisplayName("Retorna street invalida quando inserir streetName")
    public void shouldReturnNameInvalid_WhenInsideStreet(){
        StreetModel streetTest = new StreetModel(1L,null);
        Assertions.assertDoesNotThrow(() -> service.insert(streetTest) );
    }

    @Test
    @DisplayName("Retorna sucesso quando inserir streetName")
    public void shouldReturnSucess_WhenInsideStreet(){
        StreetModel streetTest = new StreetModel(1L,"streetTeste1");
        Assertions.assertDoesNotThrow(() -> service.insert(streetTest) );
    }

    @BeforeEach
    public void setup(){
        StreetModel street = new StreetModel(1L, "streetTeste");

        Mockito.when(repository.findById(street.getIdStreet())).thenReturn(java.util.Optional.of(street));
        Mockito.when(repository.findByStreetName(street.getStreetName())).thenReturn(java.util.Optional.of(street));
    }
}