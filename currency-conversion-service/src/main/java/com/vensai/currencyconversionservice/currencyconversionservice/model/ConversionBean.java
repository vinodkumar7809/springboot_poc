package com.vensai.currencyconversionservice.currencyconversionservice.model;

import java.math.BigDecimal;

public class ConversionBean {
	
	private long id;
	private String from;
	private String to;
	private BigDecimal exchange;
	private BigDecimal quantity;
	private BigDecimal totalCalAmt;
	private int port;
	
	public ConversionBean() {
		super();
	}
	
	public ConversionBean(long id, String from, String to, BigDecimal exchange, BigDecimal quantity,
			BigDecimal totalCalAmt, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchange = exchange;
		this.quantity = quantity;
		this.totalCalAmt = totalCalAmt;
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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalAmt() {
		return totalCalAmt;
	}
	public void setTotalCalAmt(BigDecimal totalCalAmt) {
		this.totalCalAmt = totalCalAmt;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	

}
