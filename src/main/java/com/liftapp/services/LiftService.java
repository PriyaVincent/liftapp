package com.liftapp.services;

import com.liftapp.models.Lift;

public interface LiftService {
	
	public Lift getNearestLift(String buttonId);

}
