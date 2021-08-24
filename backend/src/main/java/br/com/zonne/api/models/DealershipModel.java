package br.com.zonne.api.models;


import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_dealership")
public class DealershipModel {

    @Id
    private String dealershipName;

    public DealershipModel(DealershipModel entity){
        dealershipName = entity.getDealershipName();
    }
}
