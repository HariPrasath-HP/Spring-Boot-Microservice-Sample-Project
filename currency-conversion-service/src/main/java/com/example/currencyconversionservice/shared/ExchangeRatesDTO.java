package com.example.currencyconversionservice.shared;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ExchangeRatesDTO {

    private String base;
    private String date;
    private Rates rates;
    @Data
    public class Rates {
        public Double AFN;
        public Double EUR;
        public Double GBP;
        public Double JPY;
        public Double USD;
    }
    private String success;
    private String timestamp;

}
