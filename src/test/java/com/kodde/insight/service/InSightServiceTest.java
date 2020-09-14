package com.kodde.insight.service;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

import com.kodde.insight.client.InSightClient;
import com.kodde.insight.dto.AvailableSolsDTO;
import com.kodde.insight.dto.SolDTO;

@SpringBootTest(properties = "spring.cache.type=NONE")
@DirtiesContext
public class InSightServiceTest {
	
	private static final String KEY = "4guzfV3ceojrQKMiY09CZi1omgTHSs4irI7dyzKP";
	private static final String VERSION = "1.0";
	private static final String FEED_TYPE = "json";

	@MockBean
	private InSightClient inSightClient;
	
	@Autowired
	private InSightService inSightService;
	
	@Test
	public void getWeatherMeasuresThrowsJSONException() {
		given(inSightClient.getWeatherMeasures(KEY, FEED_TYPE, VERSION)).willReturn("'634':'AT':{'av':-61.082,'ct':314284,'mn':-94.58,'mx':-16.136},'First_UTC':'2020-09-07T15:29:16Z','HWS':{'av':6.685,'ct':156912,'mn':0.452,'mx':17.887},'Last_UTC':'2020-09-08T16:08:49Z','PRE':{'av':775.846,'ct':159956,'mn':746.3902,'mx':793.7311},'Season':'summer',}'sol_keys':['634']}");
		assertThrows(JSONException.class, () -> inSightService.getWeatherMeasures());
	}
	
	@Test
	public void getWeatherMeasures() throws JSONException {
		given(inSightClient.getWeatherMeasures(KEY, FEED_TYPE, VERSION)).willReturn("{'634':{'AT':{'av':-61.082,'ct':314284,'mn':-94.58,'mx':-16.136},'First_UTC':'2020-09-07T15:29:16Z','HWS':{'av':6.685,'ct':156912,'mn':0.452,'mx':17.887},'Last_UTC':'2020-09-08T16:08:49Z','PRE':{'av':775.846,'ct':159956,'mn':746.3902,'mx':793.7311},'Season':'summer'},'sol_keys':['634']}");
		
		AvailableSolsDTO actual = inSightService.getWeatherMeasures();
		List<SolDTO> availableSols = new ArrayList<SolDTO>();
		SolDTO solDTO = new SolDTO(634,
				new Double(-61.082));
		availableSols.add(solDTO);
		assertThat(actual.getAvailableSols().get(0)).isEqualTo(availableSols.get(0));
	}
}
