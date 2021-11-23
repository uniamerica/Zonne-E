package br.com.zonne.api.repositories;

import br.com.zonne.api.models.StreetModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreetRepository extends JpaRepository<StreetModel, Long> {
    Optional<StreetModel> findByStreetName(String name);
}