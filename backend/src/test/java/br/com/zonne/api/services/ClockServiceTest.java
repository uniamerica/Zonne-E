package br.com.zonne.api.services;

import br.com.zonne.api.models.ClockModel;
import br.com.zonne.api.models.DeviceModel;
import br.com.zonne.api.repositories.ClockRepository;

import br.com.zonne.api.repositories.DeviceRepository;
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
public class ClockServiceTest {


    @Autowired
    ClockService service;

    @MockBean
    ClockRepository repository;

    @Test
    public void clockServiceTestFindById(){
        Long id = 1L;
        ClockModel clockTest = service.findById(id);
        Assertions.assertEquals(clockTest.getIdClock(), id);
    }

    @Test
    public void clockServiceTestInsertDevice(){
        ClockModel clockTest = new ClockModel(1l,2.5,6.5);
        Mockito.when(repository.save(clockTest)).thenReturn(clockTest);
        ClockModel clockInserted = service.findById(1L);

        Assertions.assertEquals(clockTest,clockInserted);
        Assertions.assertNotNull(clockInserted);
        System.out.println(clockInserted);

    }

    @Test
    public void clockServiceTestEdit(){
        ClockModel clockTest = service.findById(1L);
        ClockModel clockToCompare = new ClockModel(1L,2.5,6.5);

        clockTest.setEnergyExpend(25.5);

        service.edit(1L, clockTest);

        ClockModel clockEdit = new ClockModel();

        clockEdit.setIdClock(clockTest.getIdClock());
        clockEdit.setEnergyExpend(clockTest.getEnergyExpend());
        clockEdit.setEnergyCredit(clockTest.getEnergyCredit());

        Assertions.assertEquals(clockTest, clockEdit);
        Assertions.assertNotEquals(clockToCompare, clockEdit);

    }

    @BeforeEach
    public void setup(){
        ClockModel clock = new ClockModel(1L,2.5,6.5);

        Mockito.when(repository.findById(clock.getIdClock())).thenReturn(java.util.Optional.of(clock));
    }
}
