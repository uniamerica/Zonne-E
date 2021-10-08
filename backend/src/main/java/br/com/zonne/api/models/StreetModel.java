package br.com.zonne.api.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_street")
public class StreetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStreet ;

    private String streetName;

    public StreetModel (StreetModel entity){
        idStreet = entity.getIdStreet();
        streetName = entity.getStreetName();
    }
}