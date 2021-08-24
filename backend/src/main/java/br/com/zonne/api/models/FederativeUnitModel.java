package br.com.zonne.api.models;


import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="tb_federativeUnit")
public class FederativeUnitModel {

    @Id
    private String federativeUnitName;
    private String federativeUnitPrefix;


    public FederativeUnitModel(FederativeUnitModel entity){
        federativeUnitName = entity.getFederativeUnitName();
        federativeUnitPrefix = entity.getFederativeUnitPrefix();
    }
}
