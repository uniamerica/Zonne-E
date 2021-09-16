package br.com.zonne.api.repositories;

import br.com.zonne.api.models.DealershipModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DealershipRepository  extends  JpaRepository<DealershipModel, Long>{
    Optional<DealershipModel> findByName(String name);
}
