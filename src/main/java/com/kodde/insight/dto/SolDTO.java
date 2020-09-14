package com.kodde.insight.dto;

import java.io.Serializable;

public class SolDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int sol;
	private Double average;
	
	public SolDTO(int sol, Double average) {
		this.sol = sol;
		this.average = average;
	}
	
	public int getSol() {
		return sol;
	}
	public void setSol(int sol) {
		this.sol = sol;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolDTO other = (SolDTO) obj;
		if (average == null) {
			if (other.average != null)
				return false;
		} else if (!average.equals(other.average))
			return false;
		if (sol != other.sol)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SolDTO [sol=" + sol + ", average=" + average + "]";
	}
}
