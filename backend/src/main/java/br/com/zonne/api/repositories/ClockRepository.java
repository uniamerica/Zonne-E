package br.com.zonne.api.repositories;

import br.com.zonne.api.models.ClockModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClockRepository extends JpaRepository<ClockModel, Long>{
}
