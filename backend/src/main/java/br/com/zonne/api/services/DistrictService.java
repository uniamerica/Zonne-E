package br.com.zonne.api.services;

import br.com.zonne.api.exceptions.DistrictNotFoundException;
import br.com.zonne.api.models.DealershipModel;
import br.com.zonne.api.models.DistrictModel;
import br.com.zonne.api.repositories.DistrictRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository repository;

    // FIND ALL
    public List<DistrictModel> findAll() {
        List<DistrictModel> result = repository.findAll();
        return result.stream().map(x -> new DistrictModel(x)).collect(Collectors.toList());
    }

    // POST DISTRICT
    public DistrictModel insert(DistrictModel district){
        DistrictModel unit = new DistrictModel();

        unit.setIdDistrict(district.getIdDistrict());
        unit.setDistrictName(district.getDistrictName());

        unit = repository.save(unit);

        return unit;
    }

    // FIND BY ID
    public DistrictModel findById(Long id) {
        Optional<DistrictModel> result = repository.findById(id);
        return result.orElseThrow(() -> new DistrictNotFoundException("District not found. Please try again."));
    }

    public DistrictModel edit(Long id, DistrictModel update){
        DistrictModel updated = findById(id);

        updated.setIdDistrict(update.getIdDistrict());
        updated.setDistrictName(update.getDistrictName());

        repository.save(update);

        return updated;
    }

    public void deleteById(Long id) {
        repository.delete(findById(id));
    }
}