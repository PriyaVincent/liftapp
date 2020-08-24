package com.liftapp.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liftapp.configurations.LiftDetailsConfigurations;
import com.liftapp.configurations.LiftButtonConfigurations.Button;
import com.liftapp.models.Lift;
import com.liftapp.utils.LiftFactory;

@Service
public class LiftServiceImpl implements LiftService {

	private static final Logger LOGGER = LogManager.getLogger(LiftServiceImpl.class);

	@Autowired
	LiftFactory liftFactory;

	@Autowired
	LiftButtonService liftButtonService;

	@Autowired
	LiftDetailsConfigurations liftDetailsConfigurations;

	@Override
	public Lift getNearestLift(String buttonId) {

		LOGGER.info("liftDetailsConfigurations.getLiftDetails().getLifts() : "
				+ liftDetailsConfigurations.getLiftDetails().getLifts().size());
		liftFactory.setLifts(liftDetailsConfigurations.getLiftDetails().getLifts());

		Button clickedButton = liftButtonService.getLiftButton(buttonId);
		return liftFactory.getLift(clickedButton.getDirection(), clickedButton.getFloor());
	}

}
