package com.app.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.AirlineService;



@RestController
@RequestMapping("api/airline")
public class AirlineController {
	
	JSONObject json = new JSONObject();
	
	@Autowired
	private AirlineService airlineService;
	
	@GetMapping("/getAllAirlineDetails")
	public List<Map<String, Object>> getAllAirlineDetails(){
		return airlineService.getAllAirlineDetails();
	}

}
