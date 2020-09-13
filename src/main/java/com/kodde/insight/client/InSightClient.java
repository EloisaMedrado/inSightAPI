package com.kodde.insight.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://api.nasa.gov/insight_weather", name="inSightWeather")
public interface InSightClient {

	@GetMapping("/?api_key={key}&feedtype={feedtype}&ver={version}")
    String getWeatherMeasures(@PathVariable("key") String key, 
    		@PathVariable("feedtype") String feedtype,
    		@PathVariable("version") String version);
}
