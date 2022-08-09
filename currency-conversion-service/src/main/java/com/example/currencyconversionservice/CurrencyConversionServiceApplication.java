package com.example.currencyconversionservice;

import com.example.currencyconversionservice.shared.ExchangeRatesDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
		//WebClient c= WebClient.builder().build().get();
		Mono<ExchangeRatesDTO> client = WebClient.builder()
				.build().get()
				.uri("https://api.apilayer.com/exchangerates_data/latest?symbols=USD%2CEUR%2CJPY%2CAFN%2CGBP&base=INR")
				//"https://api.apilayer.com/exchangerates_data/convert?to=inr&from=usd&amount=1"
				.header("apikey", "TiBG3DL3cbK7bLBL3Wu5t5uKGDPWywbJ")
				.retrieve().bodyToMono(ExchangeRatesDTO.class);
		System.out.println("roleDetailsDTOMono = " + client.block().toString());
		//ExchangeRatesDTO readers = client.block();
		System.out.println("readers.toString() = " + client.toString());
		//List<ExchangeRatesDTO> temp = Arrays.asList(readers);
		//System.out.println("temp = " + temp);
	}

}
