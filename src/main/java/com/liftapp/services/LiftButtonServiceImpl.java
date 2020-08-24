package com.liftapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liftapp.configurations.LiftButtonConfigurations;
import com.liftapp.configurations.LiftButtonConfigurations.Button;

@Service
public class LiftButtonServiceImpl implements LiftButtonService {

	@Autowired
	LiftButtonConfigurations liftButtonConfigurations;

	@Override
	public Button getLiftButton(String buttonId) {
		System.out.println("Button size: "+liftButtonConfigurations.getButtons().size());
		
		
		Button clickedButton = liftButtonConfigurations.getButtons().stream()
				.filter(button -> buttonId.equals(button.getId().toString())).findAny().get();
		return clickedButton;
	}

}
