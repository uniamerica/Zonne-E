package br.com.zonne.api.repositories;

import br.com.zonne.api.models.DistrictModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DistrictRepository extends JpaRepository<DistrictModel, String>{
}