package com.liftapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liftapp.models.Lift;
import com.liftapp.services.LiftService;

@RestController
@RequestMapping("/")
public class LiftController {

	@Autowired
	LiftService liftService;
	
	@GetMapping("/health")
	public ResponseEntity<String> handshake() {
		return new ResponseEntity<String>("Ok", HttpStatus.OK);

	}

	@GetMapping("/lifts/{buttonId}")
	public Lift getBill(@RequestHeader HttpHeaders headers, @PathVariable("buttonId") String buttonId) {
		Lift lift = liftService.getNearestLift(buttonId);
		return lift;
	}

}
