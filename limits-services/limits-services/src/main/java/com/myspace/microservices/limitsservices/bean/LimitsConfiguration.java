package com.myspace.microservices.limitsservices.bean;


public class LimitsConfiguration {
	
	private int maximum = 1000;
	private int minimum = 1;
	
	
	public LimitsConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}
	
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	
}
