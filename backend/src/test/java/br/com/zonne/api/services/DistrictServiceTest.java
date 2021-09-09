package br.com.zonne.api.services;

import br.com.zonne.api.models.DistrictModel;
import br.com.zonne.api.models.UserModel;
import br.com.zonne.api.repositories.DistrictRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DistrictServiceTest {

    @TestConfiguration
    static class DistrictServiceTestConfiguration {

        @Bean
        public DistrictService districtService() {
            return new DistrictService();
        }
    }

    @Autowired
    DistrictService service;

    @MockBean
    DistrictRepository repository;

    @Test
    public void districtServiceTestFindById(){
        String id = "1";
        DistrictModel districtTest = service.findById(id);
        Assertions.assertEquals(districtTest.getIdDistrict(), id);
    }
    @Test
    public void userServiceTestInsertUser(){
        DistrictModel districtTest = new DistrictModel("1", "bairroTeste");
        Mockito.when(repository.save(districtTest)).thenReturn(districtTest);
        DistrictModel districtInserted = service.findById("1");

        Assertions.assertEquals(districtTest, districtInserted);
        Assertions.assertNotNull(districtInserted);
        System.out.println(districtInserted);

    }

    @Before
    public void setup(){
        DistrictModel district = new DistrictModel("1", "bairroTeste");

        Mockito.when(repository.findById(district.getIdDistrict())).thenReturn(java.util.Optional.of(district));

    }
}
