package com.example.currencyexchangeservice;

import com.example.currencyexchangeservice.DTO.CurrencyExchangeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
    private final Environment environment;

    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public  HashMap<String,String> currencyExchange(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable Double quantity
    ){
        CurrencyExchangeResponseDTO client = WebClient.builder()
                .build().get()
                .uri("https://api.apilayer.com/exchangerates_data/convert?to="+to+"&from="+from+"&amount="+quantity)
                //"https://api.apilayer.com/exchangerates_data/convert?to=inr&from=usd&amount=1"
                .header("apikey", "TiBG3DL3cbK7bLBL3Wu5t5uKGDPWywbJ")
                .retrieve().bodyToMono(CurrencyExchangeResponseDTO.class).block();
        HashMap<String,String> response = new HashMap<>();
        response.put("result",client.result.toString());
        response.put("rate",client.info.rate.toString());
        response.put("timestamp",client.info.timestamp);
        response.put("response-environment",environment.getProperty("local.server.port"));
        return response;
    }
}
