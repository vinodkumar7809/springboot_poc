package com.vensai.currencyexchangeservice.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vensai.currencyexchangeservice.currencyexchangeservice.model.ExchangeValue;
import com.vensai.currencyexchangeservice.currencyexchangeservice.repository.ExchangeServiceRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	ExchangeServiceRepository exchangeRepo;

	public ExchangeValue findByFromAndTo(String from, String to) {
		return exchangeRepo.findByFromAndTo(from, to);

	}

}
