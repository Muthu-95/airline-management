package com.app.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.ApplicationException;
import com.app.exception.ErrorCode;
import com.app.model.Airlines;
import com.app.repository.AirlineRepository;
import com.app.service.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;

	@Override
	public List<Map<String, Object>> getAllAirlineDetails() {
		List<Map<String, Object>> airlineDetails = null;
		try {
			airlineDetails = airlineRepository.getAllAirlineDetails();
			if (airlineDetails.isEmpty())
				throw new ApplicationException(ErrorCode.AIRLINE_DETAILS_NOTFOUND);
		} catch (ApplicationException e) {
			throw new ApplicationException(ErrorCode.AIRLINE_DETAILS_NOTFOUND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return airlineDetails;
	}

	@Override
	public Airlines getAirlineById(int airlineId) {
		Airlines airline = null;
		try {
			airline = airlineRepository.getAirlineById(airlineId);
			if (airline == null)
				throw new ApplicationException(ErrorCode.INVALID_AIRLINE_ID);
		} catch (ApplicationException e) {
			throw new ApplicationException(ErrorCode.INVALID_AIRLINE_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return airline;
	}

}
