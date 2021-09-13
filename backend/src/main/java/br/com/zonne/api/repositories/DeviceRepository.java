package br.com.zonne.api.repositories;

import br.com.zonne.api.models.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DeviceRepository extends JpaRepository<DeviceModel, Long> {
}