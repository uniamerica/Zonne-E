package br.com.zonne.api.repositories;

<<<<<<< HEAD
import br.com.zonne.api.models.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DealershipRepository extends JpaRepository<DeviceModel, String>{

=======
import br.com.zonne.api.models.DealershipModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DealershipRepository  extends  JpaRepository<DealershipModel, Long>{
>>>>>>> 59ece6ec2dc4bd22ef53569e04cfac1642ce414d
}
