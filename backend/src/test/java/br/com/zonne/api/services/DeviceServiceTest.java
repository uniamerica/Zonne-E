package br.com.zonne.api.services;

import br.com.zonne.api.models.DeviceModel;
import br.com.zonne.api.repositories.DeviceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeviceServiceTest {

    @TestConfiguration
    static class DeviceServiceTestConfiguration{

        @Bean
        public DeviceService deviceService(){
            return new DeviceService();
        }
    }

    @Autowired
    DeviceService service;

    @MockBean
    DeviceRepository repository;

    @Test
    public void deviceServiceTestFindById(){
        Long id = 1L;
        DeviceModel deviceTest = service.findById(id);
        Assertions.assertEquals(deviceTest.getIdDevice(), id);
    }

    @Test
    public void deviceServiceTestInsertDevice(){
        DeviceModel deviceTest = new DeviceModel(1L,"100","50","200","80");
        Mockito.when(repository.save(deviceTest)).thenReturn(deviceTest);
        DeviceModel deviceInserted = service.findById(1L);

        Assertions.assertEquals(deviceTest,deviceInserted);
        Assertions.assertNotNull(deviceInserted);
        System.out.println(deviceInserted);

    }

    @Test
    public void deviceServiceTestEdit(){
        DeviceModel deviceTest = service.findById(1L);
        DeviceModel deviceToCompare = new DeviceModel(1L,"100","50","200","80");

        deviceTest.setDeviceValueKw("1000");

        service.edit(1L, deviceTest);

        DeviceModel deviceEdit = new DeviceModel();

        deviceEdit.setIdDevice(deviceTest.getIdDevice());
        deviceEdit.setDeviceValueKw(deviceTest.getDeviceValueKw());
        deviceEdit.setDeviceValueBasic(deviceTest.getDeviceValueBasic());
        deviceEdit.setDeviceValueIlum(deviceTest.getDeviceValueIlum());
        deviceEdit.setDeviceValueSolarPanel(deviceTest.getDeviceValueSolarPanel());


        Assertions.assertEquals(deviceTest, deviceEdit);
        Assertions.assertNotEquals(deviceToCompare, deviceEdit);

    }

    @Before
    public void setup(){
        DeviceModel device = new DeviceModel(1L,"100","50","200","80");

        Mockito.when(repository.findById(device.getIdDevice())).thenReturn(java.util.Optional.of(device));
    }
}
