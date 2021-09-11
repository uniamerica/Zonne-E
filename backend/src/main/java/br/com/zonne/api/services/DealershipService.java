package br.com.zonne.api.services;

import br.com.zonne.api.models.DealershipModel;
import br.com.zonne.api.models.DistrictModel;
import br.com.zonne.api.repositories.DealershipRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DealershipService {

    @Autowired
    private DealershipRepository repository;

    //FIND ALL
    public List<DealershipModel> findAll() {
        List<DealershipModel> result = repository.findAll();
        return result.stream().map(x -> new DistrictModel(x)).collect(Collectors.toList());
    }

    //POST DEALERSHIP
    public DealershipModel insert(DealershipModel dealership){
        DealershipModel unit = new DealershipModel();

        unit.setIdDealership(dealership.getIdDealership());
        unit.setDealershipName(dealership.getDealershipName());

        unit = repository.save(unit);

        return unit;
    }

    //FIND BY ID
    public  DealershipModel findById(Long id){
        Optional<DealershipModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ServiceException("District not found. Please try again."));
    }
}
