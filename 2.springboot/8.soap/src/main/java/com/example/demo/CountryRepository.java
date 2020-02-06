package com.example.demo;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
	private static final Map<String, Country> countries = new HashMap<>();

	Country newCountry(String name, String capital, Currency currency, int population) {
		var country = new Country();
		country.setName(name);
		country.setCapital(capital);
		country.setCurrency(currency);
		country.setPopulation(population);
		return country;
	}
	
	@PostConstruct
	public void initData() {
		countries.put("Spain", newCountry("Spain", "Madrid", Currency.EUR, 46704314));
		countries.put("Poland", newCountry("Poland", "Warsaw", Currency.PLN, 38186860));
		countries.put("United Kingdom", newCountry("United Kingdom", "London", Currency.GBP, 63705000));
	}

	public Country findCountry(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return countries.get(name);
	}
}