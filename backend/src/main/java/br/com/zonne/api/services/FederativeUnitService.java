package br.com.zonne.api.services;

import br.com.zonne.api.models.FederativeUnitModel;
import br.com.zonne.api.repositories.FederativeUnitRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class FederativeUnitService {

    @Autowired
    private FederativeUnitRepository repository;

    // FIND ALL
    public List<FederativeUnitModel> findAll(){
        List<FederativeUnitModel> result = repository.findAll();
        return result.stream().map(x -> new FederativeUnitModel(x)).collect(Collectors.toList());
    }

    //POST FEDERATIVEUNIT
    public FederativeUnitModel insert(FederativeUnitModel federativeUnit){
        FederativeUnitModel unit = new FederativeUnitModel();

        unit.setIdFederativeUnit(federativeUnit.getIdFederativeUnit());
        unit.setFederativeUnitName(federativeUnit.getFederativeUnitName());
        unit.setFederativeUnitPrefix(federativeUnit.getFederativeUnitPrefix());

        unit = repository.save(unit);

        return unit;
    }

    //FIND BY ID
    public FederativeUnitModel findById(Long id){
        Optional<FederativeUnitModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ServiceException("District not found. Please try again."));
    }
}
