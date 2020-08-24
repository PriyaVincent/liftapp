package com.liftapp.utils;

import java.util.Comparator;

import com.liftapp.models.Lift;

public class LiftDirectionInProgressComparator implements Comparator<Lift> {

	@Override
	public int compare(Lift l1, Lift l2) {
		return l1.getDirection().compareTo(l2.getDirection());
	}

}
