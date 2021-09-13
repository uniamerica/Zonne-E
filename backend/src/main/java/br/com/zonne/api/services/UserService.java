package br.com.zonne.api.services;

import br.com.zonne.api.models.UserModel;
import br.com.zonne.api.repositories.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
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
        if(userModel.isPresent()){
            System.out.println("User already exists");
            throw new ServiceException("User already exists");
        }
        System.out.println(userModel);

        if (isCPF(user.getCpf()) == false){
            System.out.println("CPF invalid, please try again");
            throw new ServiceException("CPF invalid, please try again");
        }
        UserModel unit = new UserModel();
        unit.setCpf(user.getCpf());
        unit.setUserName(user.getUserName());
        unit.setUserLastName(user.getUserLastName());
        unit.setUserEmail(user.getUserEmail());
        unit.setUserPassword(user.getUserPassword());

        unit = repository.save(unit);

        return unit;
    }

    public UserModel findByCpf(String cpf) {
        Optional<UserModel> result = repository.findByCpf(cpf);
        return result.orElseThrow(() -> new ServiceException("User not found. Please try again."));
    }

    public void deleteByCpf(String cpf){
        repository.delete(findByCpf(cpf));
    }

    public UserModel edit(String cpf, UserModel update){
        UserModel updated = findByCpf(cpf);

        updated.setCpf(update.getCpf());
        updated.setUserName(update.getUserName());
        updated.setUserLastName(update.getUserLastName());
        updated.setUserEmail(update.getUserEmail());
        updated.setUserPassword(update.getUserPassword());

        repository.save(updated);

        return updated;
    }

    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String printCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
}

