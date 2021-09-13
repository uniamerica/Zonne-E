package br.com.zonne.api.models;

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

    public DeviceModel(DeviceModel entity){
        idDevice = entity.getIdDevice();
        deviceValueKw = entity.getDeviceValueKw();
        deviceValueBasic = entity.getDeviceValueBasic();
        deviceValueIlum = entity.getDeviceValueIlum();
        deviceValueSolarPanel = entity.getDeviceValueSolarPanel();
    }

}
