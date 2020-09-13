package com.kodde.insight.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kodde.insight.client.InSightClient;
import com.kodde.insight.dto.SolDTO;
import com.kodde.insight.utils.Constants;

@Service
public class InSightService {

	@Value("${api.key}")
	private String apiKey;
	
	@Value("${api.feedtype}")
	private String feedType;
	
	@Value("${api.version}")
	private String version;
	
	@Autowired
	private InSightClient inSightClient;
	
	public List<SolDTO> getWeatherMeasures() throws JSONException {
		String result = inSightClient.getWeatherMeasures(apiKey, feedType, version);
		
		JSONObject jsonObj = new JSONObject(result);
		JSONArray solKeys = jsonObj.getJSONArray(Constants.SOL_KEYS);

		List<SolDTO> availableSols = new ArrayList<SolDTO>();
		for(int i = 0; i < solKeys.length(); i++) {
			String key = solKeys.getString(i);
			JSONObject sol = jsonObj.getJSONObject(key);
			JSONObject atmTemperature = sol.getJSONObject(Constants.AT);
			
			SolDTO solDTO = new SolDTO(solKeys.getInt(i), 
					atmTemperature.getDouble(Constants.MIN), 
					atmTemperature.getDouble(Constants.MAX), 
					atmTemperature.getDouble(Constants.AVG));
			availableSols.add(solDTO);
		}
		
        return availableSols;
    }
}
