package com.takako;

/*abstract*/ class Money implements Expression {
	protected int amount;
	protected String currency;
	
	Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	String currency() {
		return currency;
	}
	
	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount
				&& currency().equals(money.currency());
	}
	
	static Money doller(int amount) {
		return new Money(amount, "USD");
	}
	
	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	//abstract Money times(int multiplier);
	/*Money times(int amount) {
		return null;
	}*/
	
	public Expression times(int multiplier) {
		// TODO Auto-generated method stub
		return  new Money(amount * multiplier, currency);
	}
	
	public String toString() {
		return amount + " " + currency;
	}
	
	public Expression plus (Expression addend) {
		return new Sum(this, addend);
	}
	
	public Money reduce(Bank bank, String to) {
		/*int rate = (currency.equals("CHF") && to.equals("USD"))
		? 2
		: 1;
		return new Money(amount / rate, to);*/
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
}
