package br.com.zonne.api.services;

import br.com.zonne.api.models.FederativeUnitModel;
import br.com.zonne.api.repositories.FederativeUnitRepository;
import org.hibernate.service.spi.ServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FederativeUnitServiceTest {

    @TestConfiguration
    static class FederativeUnitServiceTestConfiguration {

        @Bean
        public FederativeUnitService federativeUnitService(){ return new FederativeUnitService(); }

    }

    @Autowired
    FederativeUnitService service;

    @MockBean
    FederativeUnitRepository repository;

    @Test
    public void federativeUnitServiceTestFindById(){
        Long id = 1L;
        FederativeUnitModel federativeUnitTest = service.findById(id);
        Assertions.assertEquals(federativeUnitTest.getIdFederativeUnit(), id);
    }

    @Test
    public void federativeUnitServiceInsertFederativeUnit(){
        FederativeUnitModel federativeUnitTest = new FederativeUnitModel(1L,"federativeUnitTeste","FU");
        Mockito.when(repository.save(federativeUnitTest)).thenReturn(federativeUnitTest);
        FederativeUnitModel federativeUnitInserted = service.findById(1L);

        Assertions.assertEquals(federativeUnitTest, federativeUnitInserted);
        Assertions.assertNotNull(federativeUnitInserted);
        System.out.println(federativeUnitInserted);

    }
    @Test
    public void federativeUnitServiceTestEdit(){
        FederativeUnitModel federativeUnitTest = service.findById(1L);
        FederativeUnitModel federativeUnitToCompare = new FederativeUnitModel(1L,"federativeUnitTeste","FU");

        federativeUnitTest.setFederativeUnitName("Estado");

        service.edit(1L,federativeUnitTest);

        FederativeUnitModel federativeUnitEdit = new FederativeUnitModel();

        federativeUnitEdit.setIdFederativeUnit(federativeUnitTest.getIdFederativeUnit());
        federativeUnitEdit.setFederativeUnitName(federativeUnitTest.getFederativeUnitName());
        federativeUnitEdit.setFederativeUnitPrefix(federativeUnitTest.getFederativeUnitPrefix());

        Assertions.assertEquals(federativeUnitTest, federativeUnitEdit);
        Assertions.assertNotEquals(federativeUnitToCompare, federativeUnitEdit);

        System.out.println(" " + federativeUnitEdit.getIdFederativeUnit() + " " + federativeUnitEdit.getFederativeUnitName() + " " + federativeUnitEdit.getFederativeUnitPrefix());
        System.out.println(" " + federativeUnitToCompare.getIdFederativeUnit() + " " + federativeUnitToCompare.getFederativeUnitName() + " " + federativeUnitToCompare.getFederativeUnitPrefix());
    }
    @Test
    @DisplayName("Retorna federativeUnit invalido quando inserir federativeUnitName")
    public void  shouldReturnNameInvalid_WhenInsiderFederativeUnit(){
        FederativeUnitModel federativeUnitTest = new FederativeUnitModel(1L, null,null);
        Assertions.assertThrows(ServiceException.class, () -> service.insert(federativeUnitTest) );
    }
    @Test
    @DisplayName("Retorna sucesso quando inserir federativeUnitName")
    public void shouldReturnSucess_WhenInsideFederativeUnit(){
        FederativeUnitModel federativeUnitTest = new FederativeUnitModel(1L,"Estado","FU");
        Assertions.assertDoesNotThrow(() -> service.insert(federativeUnitTest) );
    }
    @Test
    @DisplayName("Retorna uma exception quando inserir federativeUnitName existente ")
    public void shouldReturnException_WhenInsideExistentFederativeUnit(){
        FederativeUnitModel federativeUnitTest = new FederativeUnitModel(1L,"federativeUnitTeste","ET");
        Assertions.assertThrows(ServiceException.class, () -> service.insert(federativeUnitTest) );
    }

    @Before
    public void setup(){
        FederativeUnitModel federativeUnit = new FederativeUnitModel(1L,"federativeUnitTeste","FU");

        Mockito.when(repository.findById(federativeUnit.getIdFederativeUnit())).thenReturn(java.util.Optional.of(federativeUnit));

    }

}
