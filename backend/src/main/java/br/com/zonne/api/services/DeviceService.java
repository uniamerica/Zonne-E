package br.com.zonne.api.services;

import br.com.zonne.api.exceptions.DeviceAcceptedException;
import br.com.zonne.api.models.DeviceModel;
import br.com.zonne.api.repositories.DeviceRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repository;

    public List<DeviceModel> findAll() {
        List<DeviceModel> result = repository.findAll();
        return result.stream().map(x -> new DeviceModel(x)).collect(Collectors.toList());
    }

    public DeviceModel insert(DeviceModel device) {
        DeviceModel unit = new DeviceModel();

        unit.setIdDevice(device.getIdDevice());
        unit.setDeviceValueKw(device.getDeviceValueKw());
        unit.setDeviceValueBasic(device.getDeviceValueBasic());
        unit.setDeviceValueIlum(device.getDeviceValueIlum());
        unit.setDeviceValueSolarPanel(device.getDeviceValueSolarPanel());
        unit.setUserModel(device.getUserModel());

        unit = repository.save(unit);

        return unit;
    }

    public DeviceModel findById(long id) {
        Optional<DeviceModel> result = repository.findById(id);
        return result.orElseThrow(() -> new DeviceAcceptedException("Device not found."));
    }
    public DeviceModel edit(Long idDevice, DeviceModel update){
        DeviceModel updated = findById(idDevice);

        updated.setDeviceValueKw(update.getDeviceValueKw());
        updated.setDeviceValueBasic(update.getDeviceValueBasic());
        updated.setDeviceValueIlum(update.getDeviceValueIlum());
        updated.setDeviceValueSolarPanel(update.getDeviceValueSolarPanel());

        repository.save(updated);

        return updated;
    }

}