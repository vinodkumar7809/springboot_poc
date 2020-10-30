package com.vensai.currencyexchangeservice.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exchange_value")
public class ExchangeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="exchange_from")
	private String from;
	@Column(name="exchange_to")
	private String to;
	@Column
	private BigDecimal exchange;
	@Column
	private int port;

	public ExchangeValue() {
		super();
	}

	public ExchangeValue(long id, String from, String to, BigDecimal exchange, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchange = exchange;
		this.port = port;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getExchange() {
		return exchange;
	}

	public void setExchange(BigDecimal exchange) {
		this.exchange = exchange;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
