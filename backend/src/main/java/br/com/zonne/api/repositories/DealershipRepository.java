package br.com.zonne.api.repositories;

import br.com.zonne.api.models.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DealershipRepository extends JpaRepository<DeviceModel, String>{

}
