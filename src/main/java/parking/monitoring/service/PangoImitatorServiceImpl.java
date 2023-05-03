package parking.monitoring.service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import parking.monitoring.CarPaymentData;

@Service
public class PangoImitatorServiceImpl implements PangoImitatorService {

	@Value("${app.payment.probability: 85}")
	int paymentProb;
	
	@Override
	public CarPaymentData getData(long carNumber) {	
		
		return isPaid(paymentProb) ? new CarPaymentData(carNumber, "paid", LocalDateTime.now(), LocalDateTime.now().plusHours(1)) : 
			new CarPaymentData(carNumber, "not-paid", LocalDateTime.now(), LocalDateTime.now().minusHours(1));
	}

	private boolean isPaid(int prob) {
		
		return ThreadLocalRandom.current().nextInt(0, 100) < prob;
	}

}
