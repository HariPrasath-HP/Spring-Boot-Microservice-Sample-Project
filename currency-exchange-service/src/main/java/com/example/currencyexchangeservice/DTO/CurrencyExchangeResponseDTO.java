package com.example.currencyexchangeservice.DTO;

import lombok.Data;

@Data
public class CurrencyExchangeResponseDTO {
    public String date;
    public Info info;
    @Data
    public class Info {
        public Double rate;
        public String timestamp;
    }
    public Double result;
    public Boolean success;
}
