package parking.monitoring.service;

import parking.monitoring.CarPaymentData;

public interface PangoImitatorService {

	CarPaymentData getData(long carNumber, String parkingZone);
}
