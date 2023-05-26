package parking.monitoring.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import parking.monitoring.CarPaymentData;
import parking.monitoring.service.PangoImitatorService;


@RestController
@RequestMapping("pango")
public class PangoImitatorController {
	
	static Logger LOG = LoggerFactory.getLogger(PangoImitatorController.class);
	@Autowired
	PangoImitatorService service;
	
	@GetMapping("/{carNumber}/{parkingZone}")
	CarPaymentData getPaymentData(@PathVariable long carNumber, @PathVariable String parkingZone) {
		LOG.debug("*pango-imitator* request for getting payment data for car: {}", carNumber);
		return service.getData(carNumber, parkingZone);
	}

}



