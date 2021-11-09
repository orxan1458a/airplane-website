package com.diplomisi.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PartOfAirplane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String partName;
    private String partType;
    private String brand;
    private String color;
    private BigDecimal price;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    private Date dateOfProduction;
    private String countryOfProduction;
    private Double weight;




}
