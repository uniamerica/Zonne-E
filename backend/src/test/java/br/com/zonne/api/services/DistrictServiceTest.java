package br.com.zonne.api.services;

import br.com.zonne.api.models.DealershipModel;
import br.com.zonne.api.models.DistrictModel;
import br.com.zonne.api.repositories.DistrictRepository;


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
public class DistrictServiceTest {

//    @TestConfiguration
//    static class DistrictServiceTestConfiguration {
//
//        @Bean
//        public DistrictService districtService() {
//            return new DistrictService();
//        }
//    }

    @Autowired
    DistrictService service;

    @MockBean
    DistrictRepository repository;

    @Test
    public void districtServiceTestFindById(){
        Long id = 1L;
        DistrictModel districtTest = service.findById(id);
        Assertions.assertEquals(districtTest.getIdDistrict(), id);
    }
    @Test
    public void districtServiceTestInsertDistrict(){
        DistrictModel districtTest = new DistrictModel(1L, "bairroTeste");
        Mockito.when(repository.save(districtTest)).thenReturn(districtTest);
        DistrictModel districtInserted = service.findById(1L);

        Assertions.assertEquals(districtTest, districtInserted);
        Assertions.assertNotNull(districtInserted);
        System.out.println(districtInserted);

    }
    @Test
    public void districtServiceTestEdit(){
        DistrictModel districtTestEdit = service.findById(1L);
        DistrictModel districtToCompare = new DistrictModel(1L,"districtTeste");

        districtTestEdit.setDistrictName("BairroTeste");

        service.edit(1L, districtTestEdit);

        DistrictModel districtEdit = new DistrictModel();

        districtEdit.setIdDistrict(districtTestEdit.getIdDistrict());
        districtEdit.setDistrictName(districtTestEdit.getDistrictName());

        Assertions.assertEquals(districtTestEdit, districtEdit);
        Assertions.assertNotEquals(districtToCompare, districtEdit);

        System.out.println(" " + districtEdit.getIdDistrict() + " " + districtEdit.getDistrictName());
        System.out.println(" " + districtToCompare.getIdDistrict() + " " + districtToCompare.getDistrictName());
    }

    @Test
    @DisplayName("Retorna district invalido quando inserir districtName")
    public void shouldReturnNameInvalid_WhenInsideDistrict(){
        DistrictModel districtTest = new DistrictModel(1L,null);
        Assertions.assertDoesNotThrow(() -> service.insert(districtTest) );
    }

    @Test
    @DisplayName("Retorna sucesso quando inserir districtName")
    public void shouldReturnSucess_WhenInsideDistrict(){
        DistrictModel districtTest = new DistrictModel(1L,"districtTeste1");
        Assertions.assertDoesNotThrow(() -> service.insert(districtTest) );
    }


    @BeforeEach
    public void setup(){
        DistrictModel district = new DistrictModel(1L, "bairroTeste");

        Mockito.when(repository.findById(district.getIdDistrict())).thenReturn(java.util.Optional.of(district));
        Mockito.when(repository.findByDistrictName(district.getDistrictName())).thenReturn(java.util.Optional.of(district));
    }
}
