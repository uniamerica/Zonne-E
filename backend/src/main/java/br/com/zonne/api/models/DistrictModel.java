package br.com.zonne.api.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_district")
public class DistrictModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistrict ;

    private String districtName;

    public DistrictModel (DistrictModel entity){
        idDistrict = entity.getIdDistrict();
        districtName = entity.getDistrictName();
    }
}