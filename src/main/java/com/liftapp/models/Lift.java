package com.liftapp.models;

import java.io.Serializable;

public class Lift implements Comparable<Integer>, Serializable {

	private static final long serialVersionUID = 1666472213463833576L;
	private Integer liftNumber;
	private String direction;
	private Integer currentFloor;

	public Lift() {
		super();
	}

	public Lift(Integer liftNumber, String direction, Integer currentFloor) {
		super();
		this.direction = direction;
		this.currentFloor = currentFloor;
		this.liftNumber = liftNumber;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(Integer currentFloor) {
		this.currentFloor = currentFloor;
	}

	@Override
	public int compareTo(Integer requestedFloor) {
		return this.currentFloor - requestedFloor;
	}

	public Integer getLiftNumber() {
		return liftNumber;
	}

	public void setLiftNumber(Integer liftNumber) {
		this.liftNumber = liftNumber;
	}

}
