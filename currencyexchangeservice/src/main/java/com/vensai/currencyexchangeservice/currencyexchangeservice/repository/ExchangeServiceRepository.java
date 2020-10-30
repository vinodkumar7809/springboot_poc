package com.vensai.currencyexchangeservice.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vensai.currencyexchangeservice.currencyexchangeservice.model.ExchangeValue;

@Repository
public interface ExchangeServiceRepository extends JpaRepository<ExchangeValue, Long> {
	
	public ExchangeValue findByFromAndTo(String exchange_from, String exchange_to);

}
