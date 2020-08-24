package com.liftapp.configurations;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liftapp.models.LiftDetails;

@Configuration
@EnableConfigurationProperties
public class LiftDetailsConfigurations {

	private static final Logger LOGGER = LogManager.getLogger(LiftDetailsConfigurations.class);

	@Value("${lift.details}")
	private String liftDetailsStr;

	private LiftDetails liftDetails;

	public LiftDetails getLiftDetails() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			liftDetails = objectMapper.readValue(this.liftDetailsStr, LiftDetails.class);
			LOGGER.info("objectMapper : " + objectMapper.writeValueAsString(liftDetails));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return liftDetails;
	}

	public void setLiftDetails(LiftDetails liftDetails) {
		this.liftDetails = liftDetails;
	}

}
