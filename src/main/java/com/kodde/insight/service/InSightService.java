package com.kodde.insight.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodde.insight.client.InSightClient;

@Service
public class InSightService {

	@Autowired
	private InSightClient inSightClient;
	
	public JSONObject getWeatherMeasures() throws JSONException {
		String result = inSightClient.getWeatherMeasures("4guzfV3ceojrQKMiY09CZi1omgTHSs4irI7dyzKP", "json", "1.0");
		
		JSONObject jsonObj = new JSONObject(result);
		
        return jsonObj;
    }
}
