package br.com.zonne.api.repositories;

import br.com.zonne.api.models.DistrictModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DistrictRepository extends JpaRepository<DistrictModel, Long>{
    Optional<DistrictModel> findByDistrictName(String name);
}