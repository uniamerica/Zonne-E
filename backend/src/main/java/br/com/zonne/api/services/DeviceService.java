package br.com.zonne.api.services;

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


}
