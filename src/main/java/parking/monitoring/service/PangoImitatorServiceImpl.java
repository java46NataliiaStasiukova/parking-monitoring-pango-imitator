package parking.monitoring.service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import parking.monitoring.CarPaymentData;

@Service
public class PangoImitatorServiceImpl implements PangoImitatorService {
	static private Logger LOG = LoggerFactory.getLogger(PangoImitatorServiceImpl.class);
	@Value("${app.payment.probability: 85}")
	int paymentProb;
	
	@Override
	public CarPaymentData getData(long carNumber, String parkingZone) {	
		return isPaid(paymentProb) ? new CarPaymentData(carNumber, parkingZone, "paid", LocalDateTime.now(), LocalDateTime.now().plusHours(1)) : 
			new CarPaymentData(carNumber, parkingZone, "not-paid", LocalDateTime.now(), LocalDateTime.now().minusHours(1));
	}

	private boolean isPaid(int prob) {
		LOG.debug("*pango-imitator* checking is parking paid");
		return ThreadLocalRandom.current().nextInt(0, 100) < prob;
	}

}
