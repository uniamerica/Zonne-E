package br.com.zonne.api.services;

import br.com.zonne.api.exceptions.DeviceAcceptedException;
import br.com.zonne.api.exceptions.InversorAcceptedException;
import br.com.zonne.api.models.DeviceModel;
import br.com.zonne.api.models.InversorModel;
import br.com.zonne.api.repositories.DeviceRepository;
import br.com.zonne.api.repositories.InversorRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InversorService {

    @Autowired
    private InversorRepository repository;

    public List<InversorModel> findAll() {
        List<InversorModel> result = repository.findAll();
        return result.stream().map(x -> new InversorModel(x)).collect(Collectors.toList());
    }

    public InversorModel insert(InversorModel inversor) {
        InversorModel unit = new InversorModel();

        unit.setIdInversor(inversor.getIdInversor());
        unit.setEnergyMinute(inversor.getEnergyMinute());

        unit = repository.save(unit);

        return unit;
    }

    public InversorModel findById(long id) {
        Optional<InversorModel> result = repository.findById(id);
        return result.orElseThrow(() -> new InversorAcceptedException("Inversor not found."));
    }
    public InversorModel edit(Long idInversor, InversorModel update){
        InversorModel updated = findById(idInversor);

        updated.setIdInversor(update.getIdInversor());
        updated.setEnergyMinute(update.getEnergyMinute());

        repository.save(updated);

        return updated;
    }
}
