package com.example.currencyconversionservice.country;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "country")
public class CountryModal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="country_modal_id_generator")
    @SequenceGenerator(name="country_modal_id_generator", sequenceName = "catalogue_modal_id_sequence")
    @Column(updatable = false)
    private int id;
    private String name;
    private String code;
    private String nationality;
    private String person;
    private String currency;
    private String currencyCode;
    private String currencySymbol;
}
