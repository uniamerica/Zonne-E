package br.com.zonne.api.repositories;

import br.com.zonne.api.models.FederativeUnitModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface FederativeUnitRepository extends  JpaRepository<FederativeUnitModel, Long>{
   Optional<FederativeUnitModel> findByFederativeUnitName(String name);
}
