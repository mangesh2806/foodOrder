package com.test.loginext.foodorder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderProcessor {

	Map<String, String> customerdriverMap = new LinkedHashMap<String, String>();

	public Map<String, String> startProcessingOrders(List<Order> orderList, List<Driver> driverList) {

		for (Order order : orderList) {
			int orderTime = order.getOrderTime();
			int deliveryTime = order.getDeliveryTime();
			String customerId = order.getCustomerId();
			Driver driver = getAvailableDriver(driverList, orderTime);
			if (driver == null) {
				customerdriverMap.put(customerId, "No Food :-(");
			} else {
				customerdriverMap.put(customerId, driver.getDriverId());
				driver.setPreviousTime(orderTime + deliveryTime);
			}
		}
		return customerdriverMap;

	}

	private Driver getAvailableDriver(List<Driver> driverList, int orderTime) {
		for (Driver driver : driverList) {
			if (driver.getPreviousTime() <= orderTime) {
				return driver;
			}
		}
		return null;
	}
}
