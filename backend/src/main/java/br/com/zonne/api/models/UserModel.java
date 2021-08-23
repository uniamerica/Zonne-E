package br.com.zonne.api.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    private String cpf;

    private String userName;
    private String userLastName;
    private String userEmail;
    private String userPassword;

    public UserModel(UserModel entity){
        cpf = entity.getCpf();
        userName = entity.getUserName();
        userLastName = entity.getUserLastName();
        userEmail = entity.getUserEmail();
        userPassword = entity.getUserPassword();
    }
}
