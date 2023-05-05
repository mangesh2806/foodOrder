package com.test.loginext.foodorder;

public class Order {

	@Override
	public String toString() {
		return "Time [orderTime=" + orderTime + ", deliveryTime=" + deliveryTime + "]";
	}
	private Integer orderTime = 0;
	private Integer deliveryTime = 0;
	private String customerId;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Integer getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Integer orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
}
