package br.com.zonne.api.services;

import br.com.zonne.api.models.DealershipModel;
import br.com.zonne.api.repositories.DealershipRepository;
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
public class DealershipServiceTest {

    @TestConfiguration
    static class DealershipServiceTestConfiguration {

        @Bean
        public DealershipService dealershipService(){ return new DealershipService(); }

    }

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
   /* @Test
    public void dea
*/
}
