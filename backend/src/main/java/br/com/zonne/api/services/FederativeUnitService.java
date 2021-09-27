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

        Optional<FederativeUnitModel> federativeUnitModel = repository.findByFederativeUnitName(federativeUnit.getFederativeUnitName());
        if(federativeUnitModel.isPresent()){
            System.out.println("FederativeUnit already exists");
            throw new ServiceException("FederativeUnit already exists");
        }
        FederativeUnitModel federativeUnitTestName = new FederativeUnitModel();
        federativeUnitTestName.setFederativeUnitName(federativeUnit.getFederativeUnitName());
        if(federativeUnitTestName.getFederativeUnitName() == null ){
            System.out.println("Insert valid FederativeUnitName ");
            throw new ServiceException("Insert valid FederativeUnitName ");
        }
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

    //EDIT FEDERATIVE_UNIT
    public FederativeUnitModel edit(Long id,FederativeUnitModel update){
        FederativeUnitModel updated = findById(id);

        updated.setIdFederativeUnit(update.getIdFederativeUnit());
        updated.setFederativeUnitName(update.getFederativeUnitName());
        updated.setFederativeUnitPrefix(update.getFederativeUnitPrefix());

        repository.save(update);

        return updated;
    }
}
