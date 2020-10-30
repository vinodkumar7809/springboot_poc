package com.vensai.currencyconversionservice.currencyconversionservice.rest.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vensai.currencyconversionservice.currencyconversionservice.model.ConversionBean;


//@FeignClient(name ="currency-exchange-service", url = "http://localhost:8000")
@FeignClient(name ="currency-exchange-service")
@RibbonClient(name ="currency-exchange-service")
public interface CurrencyConversionFrignProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ConversionBean getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
