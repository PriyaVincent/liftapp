package com.lift.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.liftapp.models.Lift;
import com.liftapp.utils.LiftFactory;

@RunWith(MockitoJUnitRunner.class)
@EnableAutoConfiguration
public class LiftFactoryServiceTest {

	LiftFactory liftFactory;
	List<Lift> lifts;

	@Before
	public void setup() {
		liftFactory = new LiftFactory();

		lifts = new ArrayList<Lift>();
	}

	@Test
	public void testLiftWithUserDirection() {
		Lift lift1 = new Lift(1, "upward", 1);
		lifts.add(lift1);
		Lift lift2 = new Lift(2, "upward", 2);
		lifts.add(lift2);
		Lift lift3 = new Lift(3, "upward", 5);
		lifts.add(lift3);
		Lift lift4 = new Lift(4, "downward", 1);
		lifts.add(lift4);

		liftFactory.setLifts(lifts);

		String userDirection = "upward";
		Integer requiredFloor = 6;

		Lift resultantLift = liftFactory.getLift(userDirection, requiredFloor);

		assertEquals(lift3.getLiftNumber(), resultantLift.getLiftNumber());
	}

	@Test
	public void testLiftWithUserDirectionInDifferentOrder() {
		Lift lift1 = new Lift(2, "upward", 2);
		lifts.add(lift1);
		Lift lift2 = new Lift(3, "upward", 5);
		lifts.add(lift2);
		Lift lift3 = new Lift(1, "upward", 1);
		lifts.add(lift3);
		Lift lift4 = new Lift(4, "downward", 1);
		lifts.add(lift4);

		liftFactory.setLifts(lifts);

		String userDirection = "upward";
		Integer requiredFloor = 6;

		Lift resultantLift = liftFactory.getLift(userDirection, requiredFloor);

		assertEquals(lift2.getLiftNumber(), resultantLift.getLiftNumber());
	}

	@Test
	public void testNearestLiftIdealDirection() {
		Lift lift1 = new Lift(1, "upward", 2);
		lifts.add(lift1);
		Lift lift2 = new Lift(2, "upward", 5);
		lifts.add(lift2);
		Lift lift3 = new Lift(3, "upward", 1);
		lifts.add(lift3);
		Lift lift4 = new Lift(4, "downward", 1);
		lifts.add(lift4);
		Lift lift5 = new Lift(5, "", 1);
		lifts.add(lift5);

		liftFactory.setLifts(lifts);

		String userDirection = "downward";
		Integer requiredFloor = 6;

		Lift resultantLift = liftFactory.getLift(userDirection, requiredFloor);

		assertEquals(lift5.getLiftNumber(), resultantLift.getLiftNumber());
	}

	@Test
	public void testNearestLiftInTheSameDirectionAlongWithIdealOne() {
		Lift lift1 = new Lift(1, "upward", 2);
		lifts.add(lift1);
		Lift lift2 = new Lift(2, "upward", 5);
		lifts.add(lift2);
		Lift lift3 = new Lift(3, "downward", 7);
		lifts.add(lift3);
		Lift lift4 = new Lift(4, "", 1);
		lifts.add(lift4);

		liftFactory.setLifts(lifts);

		String userDirection = "downward";
		Integer requiredFloor = 6;

		Lift resultantLift = liftFactory.getLift(userDirection, requiredFloor);

		assertEquals(lift3.getLiftNumber(), resultantLift.getLiftNumber());
	}

	@Test
	public void testUpwardLiftWhichIsAboveTheFloor() {
		Lift lift1 = new Lift(1, "upward", 8);
		lifts.add(lift1);
		Lift lift2 = new Lift(2, "upward", 5);
		lifts.add(lift2);
		Lift lift3 = new Lift(3, "downward", 1);
		lifts.add(lift3);
		Lift lift4 = new Lift(4, "downward", 5);
		lifts.add(lift4);

		liftFactory.setLifts(lifts);

		String userDirection = "upward";
		Integer requiredFloor = 6;

		Lift resultantLift = liftFactory.getLift(userDirection, requiredFloor);

		assertEquals(lift2.getLiftNumber(), resultantLift.getLiftNumber());
	}

}
