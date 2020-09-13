package com.kodde.insight.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kodde.insight.dto.AvailableSolsDTO;
import com.kodde.insight.service.InSightService;

@RestController
@RequestMapping("/insight")
public class InSightController {
	
	@Autowired
	private InSightService inSightService;
	
	@GetMapping("/weather")
    public ResponseEntity<AvailableSolsDTO> getWeatherMeasures() {
		try {
			return new ResponseEntity<AvailableSolsDTO>(inSightService.getWeatherMeasures(), HttpStatus.OK);
		} catch (JSONException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error converting string to json", e);
		}
    }
}
