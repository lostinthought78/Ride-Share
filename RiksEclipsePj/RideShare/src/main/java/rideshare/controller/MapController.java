package rideshare.controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import rideshare.domain.Driver;
import rideshare.domain.DriverOptions;
import rideshare.service.DriverService;

@Controller
@RequestMapping("/map")
public class MapController {

	@Resource private DriverService driverService;
	
	@RequestMapping("/")
    String home(Model model) {

		return "index";
    }
	
	@RequestMapping("/findDrivers")
	@ResponseBody
	List<Driver> findDrivers(@RequestParam Double latitude
			,@RequestParam Double longitude
			,@ModelAttribute DriverOptions driverOptions
			, @RequestParam(defaultValue="1000") Integer distance, Model model) {
		return driverService.retrieveDriversWithinFeet(latitude, longitude, distance, driverOptions);
	}
	
	@RequestMapping("/selectDriver")
	@ResponseBody
	String selectDriver(@RequestParam Long driverId, Model model) {
		//Make sure driver is still available, contact driver, and return a message
		return "You're all set, your driver is on their way.";
	}
	
	@RequestMapping("/scheduleDriver")
	@ResponseBody
	String scheduleDriver(@RequestParam Long driverId, @RequestParam Integer scheduleDelay, Model model) {
		//Make sure driver is still available, notify driver of delay, and return a message
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, scheduleDelay);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d h:m a");
		return "Your ride has been scheduled for: "+ sdf.format(cal.getTime());
	}
}