package com.kodde.insight.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AvailableSolsDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<SolDTO> availableSols;
	private Date lastUpdate;
	
	public AvailableSolsDTO(List<SolDTO> availableSols, Date lastUpdate) {
		this.availableSols = availableSols;
		this.lastUpdate = lastUpdate;
	}
	
	public List<SolDTO> getAvailableSols() {
		return availableSols;
	}
	public void setAvailableSols(List<SolDTO> availableSols) {
		this.availableSols = availableSols;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
