package rideshare.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import rideshare.domain.Driver;
import rideshare.domain.DriverOptions;

@Service
public class DriverService {
	
	@Resource private DriverRepository driverRepository;
	
	public List<Driver> retrieveDriversWithinFeet(Double latitude, Double longitude, Integer maxFeet, DriverOptions driverOptions) {
		/* This should be a spatial query for performance but our in memory 
		 * database has limitations... */
		List<Driver> returnList = new ArrayList<>();
		Iterable<Driver> driverList = driverRepository.findAll();
		for(Driver driver : driverList) {
			double distance = DistanceUtil.distance(driver.getLatitude(),driver.getLongitude(), latitude, longitude);
			
			if(distance <=  maxFeet
				&& (!driverOptions.getSmoker() || !driver.getSmoker())
				&& (!driverOptions.getLuggage() || driver.getVehicleLarge())
				&& (!driverOptions.getPets() || driver.getPetsAllowed())
				&& (driverOptions.getGender().equals("") || driver.getGender().equals(driverOptions.getGender()))
					) {
				returnList.add(driver);
			}
		}
		return returnList;
	}
}