package com.vensai.currencyexchangeservice.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vensai.currencyexchangeservice.currencyexchangeservice.model.ExchangeValue;
import com.vensai.currencyexchangeservice.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeServiceController {

	@Autowired
	Environment env;

	@Autowired
	CurrencyExchangeService currencyService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue bean = currencyService.findByFromAndTo(from, to);
		bean.setPort(Integer.parseInt(env.getProperty("local.server.port")));

		return new ExchangeValue(bean.getId(), bean.getFrom(), bean.getTo(), bean.getExchange(), bean.getPort());

	}

}
