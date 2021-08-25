package br.com.zonne.api.models;

import br.com.zonne.api.controllers.DeviceController;
import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_Device")

public class DeviceModel {

    @Id
    private Double deviceValueKw;
    private Double deviceValueBasic;
    private Double deviceValueIlum;
    private Double deviceValueSolarPanel;

    public DeviceModel(DeviceModel entity){
        deviceValueKw = entity.getDeviceValueKw();
        deviceValueBasic = entity.getDeviceValueBasic();
        deviceValueBasic = entity.getDeviceValueIlum();
        deviceValueBasic = entity.getDeviceValueSolarPanel();
    }
}
