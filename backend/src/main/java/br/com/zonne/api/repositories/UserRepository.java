package br.com.zonne.api.repositories;

import br.com.zonne.api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserModel, String>{
    Optional<UserModel> findByCpf(String cpf);
}
