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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDealership;

    private String dealershipName;

    public DealershipModel(DealershipModel entity){
        idDealership = entity.getIdDealership();
        dealershipName = entity.getDealershipName();
    }
}
