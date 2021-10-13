package br.com.zonne.api.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_Clock")

public class ClockModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClock;

    private Double energyExpend;
    private Double energyCredit;

    public ClockModel(ClockModel entity){
        idClock = entity.getIdClock();
        energyExpend = entity.getEnergyExpend();
        energyCredit = entity.getEnergyCredit();
    }

}

