package br.com.zonne.api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_Device")

public class DeviceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDevice;

    private String  deviceValueKw;
    private String deviceValueBasic;
    private String deviceValueIlum;
    private String deviceValueSolarPanel;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cpf")
    private UserModel userModel;

    public DeviceModel(DeviceModel entity){
        idDevice = entity.getIdDevice();
        deviceValueKw = entity.getDeviceValueKw();
        deviceValueBasic = entity.getDeviceValueBasic();
        deviceValueIlum = entity.getDeviceValueIlum();
        deviceValueSolarPanel = entity.getDeviceValueSolarPanel();
        userModel = entity.getUserModel();
    }

}
