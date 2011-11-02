package com.takako;

// TestNGÇÃà¯êîÇÃèáÇ…íçà” assertTrue(actual, expected)
//import static org.testng.Assert.*;
import static org.testng.AssertJUnit.*;
import org.testng.annotations.Test;

public class MoneyTest {
  @Test
  public void testMultiplication() {
	  Money five = Money.doller(5);
	  assertEquals(Money.doller(10), five.times(2));
	  assertEquals(Money.doller(15), five.times(3));
  }
  @Test
  public void testEquality() {
	  assertTrue(Money.doller(5).equals(Money.doller(5)));
	  assertFalse(Money.doller(5).equals(Money.doller(6)));
//	  assertTrue(Money.franc(5).equals(Money.franc(5)));
//	  assertFalse(Money.franc(5).equals(Money.franc(6)));
	  assertFalse(Money.franc(5).equals(Money.doller(5)));
  }
//  @Test
//  public void testFrancMultiplication() {
//	  Money five = Money.franc(5);
//	  assertEquals(Money.franc(10), five.times(2));
//	  assertEquals(Money.franc(15), five.times(3));
//  }
  @Test
  public void testCurrency() {
	  assertEquals("USD", Money.doller(1).currency());
	  assertEquals("CHF", Money.franc(1).currency());
  }
/*  @Test
  public void testDifferentClassEquality() {
	  assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
  }*/
  @Test
  public void testSimpleAddition() {
	  Money five = Money.doller(5);
	  Expression sum = five.plus(five);
	  Bank bank = new Bank();
	  Money reduced = bank.reduce(sum, "USD");
	  assertEquals(Money.doller(10), reduced);
  }
  @Test
  public void testPlusReturnsSum() {
	  Money five = Money.doller(5);
	  Expression result = five.plus(five);
	  Sum sum = (Sum) result;
	  assertEquals(five, sum.augend);
	  assertEquals(five, sum.addend);
  }
  @Test
  public void testReduceSum() {
	  Expression sum = new Sum(Money.doller(3), Money.doller(4));
	  Bank bank = new Bank();
	  Money result = bank.reduce(sum,  "USD");
	  assertEquals(Money.doller(7), result);
  }
  @Test
  public void testReduceMoney() {
	  Bank bank = new Bank();
	  Money result = bank.reduce(Money.doller(1), "USD");
	  assertEquals(Money.doller(1), result);
  }
  @Test
  public void testReduceMoneyDifferentCurrency() {
	  Bank bank = new Bank();
	  bank.addRate("CHF", "USD", 2);
	  Money result = bank.reduce(Money.franc(2), "USD");
	  assertEquals(Money.doller(1), result);
  }
  //@Test
  public void testArrayEquals() {
	  assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
  }
  @Test
  public void testIdentityRate() {
	  assertEquals(1, new Bank().rate("USD", "USD"));
  }
  @Test
  public void testMixedAddition() {
	  Expression fiveBucks = Money.doller(5);
	  Expression tenFrances = Money.franc(10);
	  Bank bank = new Bank();
	  bank.addRate("CHF", "USD", 2);
	  Money result = bank.reduce(fiveBucks.plus(tenFrances), "USD");
	  assertEquals(Money.doller(10), result);
  }
  @Test
  public void testSumPlusMoney() {
	  Expression fiveBucks = Money.doller(5);
	  Expression tenFrances = Money.franc(10);
	  Bank bank = new Bank();
	  bank.addRate("CHF", "USD", 2);
	  Expression sum = new Sum(fiveBucks, tenFrances).plus(fiveBucks);
	  Money result = bank.reduce(sum, "USD");
	  assertEquals(Money.doller(15), result);
  }
  @Test
  public void testSumTimes() {
	  Expression fiveBucks = Money.doller(5);
	  Expression tenFrances = Money.franc(10);
	  Bank bank = new Bank();
	  bank.addRate("CHF", "USD", 2);
	  Expression sum = new Sum(fiveBucks, tenFrances).times(2);
	  Money result = bank.reduce(sum, "USD");
	  assertEquals(Money.doller(20), result);	  
  }
  @Test
  public void testPlusSameCurrencyReturnMoney() {
	  Expression sum =  Money.doller(1).plus(Money.doller(1));
	  assertTrue(sum instanceof Money);
  }
}