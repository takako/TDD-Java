package com.takako;

public class Doller {

	private int amount;

	public Doller(int amount) {
		// TODO Auto-generated constructor stub
		this.amount = amount;
	}

	public Doller times(int multiplier) {
		// TODO Auto-generated method stub
		return new Doller(amount * multiplier);
	}
	
	public boolean equals(Object object) {
		Doller doller = (Doller) object;
		return amount == doller.amount;
	}

}
