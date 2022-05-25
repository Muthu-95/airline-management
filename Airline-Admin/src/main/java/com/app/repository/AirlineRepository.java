package com.app.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Airlines;

@Repository
public interface AirlineRepository extends JpaRepository<Airlines, Integer> {

	@Query(value = "SELECT a.airlineId as airlineId, a.airlineName as airlineName, "
			+ "a.contactAddress as contactAddress, a.contactNumber as contactNumber "
			+ "FROM Airlines a WHERE a.isDeleted=1")
	List<Map<String, Object>> getAllAirlineDetails();

}
