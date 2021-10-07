package br.com.zonne.api.services;

import br.com.zonne.api.models.DealershipModel;
import br.com.zonne.api.repositories.DealershipRepository;
import org.hibernate.service.spi.ServiceException;


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
public class DealershipServiceTest {

//    @TestConfiguration
//    static class DealershipServiceTestConfiguration {
//
//        @Bean
//        public DealershipService dealershipService(){ return new DealershipService(); }
//
//    }

    @Autowired
    DealershipService service;

    @MockBean
    DealershipRepository repository;

    @Test
    public void dealershipServiceTestFindById(){
        Long id = 1L;
        DealershipModel dealershipTest = service.findById(id);
        Assertions.assertEquals(dealershipTest.getIdDealership(), id);
    }

    @Test
    public void dealershipServiceTestInsertDealership(){
        DealershipModel dealershipTest = new DealershipModel(1L, "dealershipTeste");
        Mockito.when(repository.save(dealershipTest)).thenReturn(dealershipTest);
        DealershipModel dealershipInserted = service.findById(1L);

        Assertions.assertEquals(dealershipTest, dealershipInserted);
        Assertions.assertNotNull(dealershipInserted);
        System.out.println(dealershipInserted);

    }
    @Test
    public void dealershipServiceTestEdit(){
        DealershipModel dealershipTest = service.findById(1L);
        DealershipModel dealershipToCompare = new DealershipModel(1L,"dealershipTeste");

        dealershipTest.setDealershipName("James");

        service.edit(1L, dealershipTest);

        DealershipModel dealershipEdit = new DealershipModel();

        dealershipEdit.setIdDealership(dealershipTest.getIdDealership());
        dealershipEdit.setDealershipName(dealershipTest.getDealershipName());

        Assertions.assertEquals(dealershipTest, dealershipEdit);
        Assertions.assertNotEquals(dealershipToCompare, dealershipEdit);

        System.out.println(" " + dealershipEdit.getIdDealership() + " " + dealershipEdit.getDealershipName());
        System.out.println(" " + dealershipToCompare.getIdDealership() + " " + dealershipToCompare.getDealershipName());
    }
    @Test
    @DisplayName("Retorna dealership invalido quando inserir dealershipname")
    public  void shouldReturnNameInvalid_WhenInsideDealership(){
        DealershipModel dealershipTest = new DealershipModel(1L,null);
        Assertions.assertThrows(ServiceException.class, () -> service.insert(dealershipTest) );
    }
    @Test
    @DisplayName("Retorna sucesso quando inserir dealershipname")
    public void shouldReturnSucess_WhenInsideDealership(){
        DealershipModel dealershipTest = new DealershipModel(1L,"dealershipTeste1");
        Assertions.assertDoesNotThrow(() -> service.insert(dealershipTest) );
    }
    @Test
    @DisplayName("Retorna uma exception quando inserir dealershipname existente ")
    public void shouldReturnException_WhenInsideExistentDealership(){
        DealershipModel dealershipTest = new DealershipModel(1L,"dealershipTeste");
        Assertions.assertThrows(ServiceException.class, () -> service.insert(dealershipTest) );
    }

    @BeforeEach
    public void setup(){
        DealershipModel dealership = new DealershipModel(1L, "dealershipTeste");
        Mockito.when(repository.findByDealershipName(dealership.getDealershipName())).thenReturn(java.util.Optional.of(dealership));
        Mockito.when(repository.findById(dealership.getIdDealership())).thenReturn(java.util.Optional.of(dealership));

    }

}
