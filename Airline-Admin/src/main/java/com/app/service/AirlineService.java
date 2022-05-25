package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.model.Airlines;

public interface AirlineService {

	List<Map<String, Object>> getAllAirlineDetails();

	Airlines getAirlineById(int airlineId);

}
