package br.com.zonne.api.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_Inversor")

public class InversorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInversor;

    private Double energyMinute;

    public InversorModel(InversorModel entity){
        idInversor = entity.getIdInversor();
        energyMinute = entity.getEnergyMinute();
    }
}
