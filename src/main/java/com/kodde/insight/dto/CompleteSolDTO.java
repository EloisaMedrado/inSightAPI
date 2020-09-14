package com.kodde.insight.dto;

import java.io.Serializable;

public class CompleteSolDTO extends SolDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double low;
	private Double high;
	
	public CompleteSolDTO(int sol, Double low, Double high, Double average) {
		super(sol, average);
		this.low = low;
		this.high = high;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompleteSolDTO other = (CompleteSolDTO) obj;
		if (high == null) {
			if (other.high != null)
				return false;
		} else if (!high.equals(other.high))
			return false;
		if (low == null) {
			if (other.low != null)
				return false;
		} else if (!low.equals(other.low))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SolDTO [low=" + low + ", high=" + high + "]";
	}
}
