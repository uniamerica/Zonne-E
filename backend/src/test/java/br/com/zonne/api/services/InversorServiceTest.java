package br.com.zonne.api.services;

import br.com.zonne.api.models.DeviceModel;
import br.com.zonne.api.models.InversorModel;
import br.com.zonne.api.repositories.DeviceRepository;
import br.com.zonne.api.repositories.InversorRepository;

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
public class InversorServiceTest {


    @Autowired
    InversorService service;

    @MockBean
    InversorRepository repository;

    @Test
    public void inversorServiceTestFindById(){
        Long id = 1L;
        InversorModel inversorTest = service.findById(id);
        Assertions.assertEquals(inversorTest.getIdInversor(), id);
    }

    @Test
    public void inversorServiceTestInsertDevice(){
        InversorModel inversorTest = new InversorModel(1L,1.5);
        Mockito.when(repository.save(inversorTest)).thenReturn(inversorTest);
        InversorModel inversorInserted = service.findById(1L);

        Assertions.assertEquals(inversorTest,inversorInserted);
        Assertions.assertNotNull(inversorInserted);
        System.out.println(inversorInserted);

    }

    @Test
    public void inversorServiceTestEdit(){
        InversorModel inversorTest = service.findById(1L);
        InversorModel inversorToCompare = new InversorModel(1L,1.5);

        inversorTest.setEnergyMinute(2.5);

        service.edit(1L, inversorTest);

        InversorModel inversorEdit = new InversorModel();

        inversorEdit.setIdInversor(inversorTest.getIdInversor());
        inversorEdit.setEnergyMinute(inversorTest.getEnergyMinute());


        Assertions.assertEquals(inversorTest, inversorEdit);
        Assertions.assertNotEquals(inversorToCompare, inversorEdit);

    }

    @BeforeEach
    public void setup(){
        InversorModel inversor = new InversorModel(1L,1.5);

        Mockito.when(repository.findById(inversor.getIdInversor())).thenReturn(java.util.Optional.of(inversor));
    }
}
