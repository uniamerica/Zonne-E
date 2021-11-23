package br.com.zonne.api.services;

import br.com.zonne.api.exceptions.ClockAcceptedException;
import br.com.zonne.api.models.ClockModel;
import br.com.zonne.api.repositories.ClockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClockService {

    @Autowired
    private ClockRepository repository;

    public List<ClockModel> findAll() {
        List<ClockModel> result = repository.findAll();
        return result.stream().map(x -> new ClockModel(x)).collect(Collectors.toList());
    }

    public ClockModel insert(ClockModel clock) {
        ClockModel unit = new ClockModel();

        unit.setIdClock(clock.getIdClock());
        unit.setEnergyExpend(clock.getEnergyExpend());
        unit.setEnergyCredit(clock.getEnergyCredit());

        unit = repository.save(unit);

        return unit;
    }

    public ClockModel findById(long id) {
        Optional<ClockModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ClockAcceptedException("Clock not found."));
    }
    public ClockModel edit(Long idClock, ClockModel update){
        ClockModel updated = findById(idClock);

        updated.setIdClock(update.getIdClock());
        updated.setEnergyExpend(updated.getEnergyExpend());
        updated.setEnergyCredit(update.getEnergyCredit());

        repository.save(updated);

        return updated;
    }

}
