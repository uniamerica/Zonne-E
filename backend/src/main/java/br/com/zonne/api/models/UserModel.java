package br.com.zonne.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DeviceModel> devices = new ArrayList<>();

    public UserModel(UserModel entity){
        cpf = entity.getCpf();
        userName = entity.getUserName();
        userLastName = entity.getUserLastName();
        userEmail = entity.getUserEmail();
        userPassword = entity.getUserPassword();
        devices = entity.getDevices().stream().map(device -> new DeviceModel(device)).collect(Collectors.toList());
    }
}
