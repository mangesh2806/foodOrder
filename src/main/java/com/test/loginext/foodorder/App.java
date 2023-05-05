package com.test.loginext.foodorder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
    	List<Order> orderList = new ArrayList<>();
    	List<Driver> driverList = new ArrayList<>();
    	int driverCount = 2;
    	int customerCount = 6;
    	
    	List<String> input = new ArrayList<>(customerCount);
    	input.add("1,10");
    	input.add("4,20");
    	input.add("15,5");
    	input.add("22,20");
    	input.add("24,10");
    	input.add("25,10");
    	
		for (int i = 0; i < customerCount; i++) {
			Order order = new Order();
			String str = input.get(i);
			String[] timeArray = str.split(",");
			int orderTime = Integer.parseInt(timeArray[0]);
			int deliveryTime = Integer.parseInt(timeArray[1]);
			order.setOrderTime(orderTime);
			order.setDeliveryTime(deliveryTime);
			int count = i + 1;
			order.setCustomerId("C" + count);
			orderList.add(order);
		}
		
		for (int i = 0; i < driverCount; i++) {
			Driver driver = new Driver();
			int count = i + 1;
			driver.setDriverId("D"+count);
			driverList.add(driver);
		}
		 
		List<Order> orderSortedList = orderList.stream()
		        .sorted(Comparator.comparingInt(Order::getOrderTime))
		        .collect(Collectors.toList());
		
		OrderProcessor processor = new OrderProcessor();
		
		System.out.println(processor.startProcessingOrders(orderSortedList, driverList));
		
    	
    	
    }
}
