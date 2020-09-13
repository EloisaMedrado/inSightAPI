package com.kodde.insight.dto;

import java.io.Serializable;

public class SolDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int sol;
	private Double low;
	private Double high;
	private Double average;
	
	public SolDTO(int sol, Double low, Double high, Double average) {
		this.sol = sol;
		this.low = low;
		this.high = high;
		this.average = average;
	}
	
	public int getSol() {
		return sol;
	}
	public void setSol(int sol) {
		this.sol = sol;
	}
	public Double getLow() {
		return low;
	}
	public void setLow(Double low) {
		this.low = low;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	
}
