package com.vensai.currencyconversionservice.currencyconversionservice.rest.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vensai.currencyconversionservice.currencyconversionservice.model.ConversionBean;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyConversionFrignProxy proxy;

	// http://localhost:8100/conversion-service/from/{from}/to/{to}/quantity{quantity}
	@GetMapping("/conversion-service/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean getCurrencyValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<ConversionBean> forEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", ConversionBean.class, uriVariables);
		ConversionBean bean = forEntity.getBody();
		return new ConversionBean(bean.getId(), from, to, bean.getExchange(), quantity,
				quantity.multiply(BigDecimal.valueOf(65)), bean.getPort());

	}
	
	@GetMapping("/conversion-service-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean getCurrencyValueUsingFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		/*Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<ConversionBean> forEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", ConversionBean.class, uriVariables);*/
		
		ConversionBean bean = proxy.getExchangeValue(from, to);
		return new ConversionBean(bean.getId(), from, to, bean.getExchange(), quantity,
				quantity.multiply(BigDecimal.valueOf(65)), bean.getPort());

	}

}
