package br.com.zonne.api.services;

import br.com.zonne.api.exceptions.StreetNotFoundException;
import br.com.zonne.api.models.StreetModel;
import br.com.zonne.api.repositories.StreetRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StreetService {

    @Autowired
    private StreetRepository repository;

    // FIND ALL
    public List<StreetModel> findAll() {
        List<StreetModel> result = repository.findAll();
        return result.stream().map(x -> new StreetModel(x)).collect(Collectors.toList());
    }

    // POST DISTRICT
    public StreetModel insert(StreetModel street){
        StreetModel unit = new StreetModel();

        unit.setIdStreet(street.getIdStreet());
        unit.setStreetName(street.getStreetName());

        unit = repository.save(unit);

        return unit;
    }

    // FIND BY ID
    public StreetModel findById(Long id) {
        Optional<StreetModel> result = repository.findById(id);
        return result.orElseThrow(() -> new StreetNotFoundException("Street not found. Please try again."));
    }

    public StreetModel edit(Long id, StreetModel update){
        StreetModel updated = findById(id);

        updated.setIdStreet(update.getIdStreet());
        updated.setStreetName(update.getStreetName());

        repository.save(update);

        return updated;
    }

    public void deleteById(Long id) {
        repository.delete(findById(id));
    }
}