package br.com.zonne.api.services;

import br.com.zonne.api.models.UserModel;
import br.com.zonne.api.repositories.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserModel> findAll() {
        List<UserModel> result = repository.findAll();
        return result.stream().map(x -> new UserModel(x)).collect(Collectors.toList());
    }

    public UserModel insert(UserModel user){
        Optional<UserModel> userModel = repository.findByCpf(user.getCpf());
        if (userModel != null){
            throw new ServiceException("User already exist");
        }
        UserModel unit = new UserModel();
        unit.setCpf(user.getCpf());
        unit.setUserName(user.getUserName());
        unit.setUserLastName(user.getUserLastName());
        unit.setUserEmail(user.getUserEmail());
        unit.setUserPassword(unit.getUserPassword());

        unit = repository.save(unit);

        return new UserModel(unit);
    }

    public UserModel findByCpf(String cpf) {
        Optional<UserModel> result = repository.findByCpf(cpf);
        return result.orElseThrow(() -> new ServiceException("User not found. Please try again."));
    }

    public void deleteByCpf(String cpf){
        repository.delete(findByCpf(cpf));
    }

    public UserModel edit(String cpf, UserModel update){
        UserModel updated = new UserModel();
        UserModel userModel = findByCpf(cpf);
        Optional<UserModel> checkUpdate = repository.findByCpf(update.getCpf());
        if (checkUpdate != null){
            throw new ServiceException("User already exist");
        }
        userModel.setCpf(update.getCpf());
        userModel.setUserName(update.getUserName());
        userModel.setUserLastName(update.getUserLastName());
        userModel.setUserEmail(update.getUserEmail());
        userModel.setUserPassword(update.getUserPassword());

        updated.setCpf(update.getCpf());
        updated.setUserName(update.getUserName());
        updated.setUserLastName(update.getUserLastName());
        updated.setUserEmail(update.getUserEmail());
        updated.setUserPassword(update.getUserPassword());

        repository.save(userModel);

        return updated;
    }


}
