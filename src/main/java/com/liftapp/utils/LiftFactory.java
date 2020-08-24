package com.liftapp.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.liftapp.models.Lift;

@Component
public class LiftFactory {

	private List<Lift> lifts;

	public Lift getLift(String requestedDirection, Integer requestFloor) {

		//Filter by the on-the way lifts and the ideal lifts from ground floor
		List<Lift> requestDirectionLifts = lifts.stream()
				.filter(lift -> requestedDirection.equals(lift.getDirection()) || "".equals(lift.getDirection()))
				.collect(Collectors.toList());
		
		//sort the lift from the ideal lifts to in-operations lifts
		Collections.sort(requestDirectionLifts, new LiftDirectionInProgressComparator());

		//find out the nearest distance lift but finding out min value of from required floor number
		Lift nearestLift = requestDirectionLifts.stream()
				.min(Comparator.comparingInt(lift -> Math.abs(lift.getCurrentFloor() - requestFloor))).get();
		return nearestLift;
	}

	public List<Lift> getLifts() {
		return lifts;
	}

	public void setLifts(List<Lift> lifts) {
		this.lifts = lifts;
	}

}
