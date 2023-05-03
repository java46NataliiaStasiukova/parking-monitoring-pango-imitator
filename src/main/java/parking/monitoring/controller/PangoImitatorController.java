package parking.monitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import parking.monitoring.CarPaymentData;
import parking.monitoring.service.PangoImitatorService;

@RestController
@RequestMapping("paymentData")
public class PangoImitatorController {
	@Autowired
	PangoImitatorService pangoService;
	
	@GetMapping("/{carNumber}")
	CarPaymentData getPaymentData(@PathVariable long carNumber) {
		return pangoService.getData(carNumber);
	}

}
