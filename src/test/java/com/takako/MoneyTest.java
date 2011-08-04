package com.takako;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class MoneyTest {
  @Test
  public void testMultiplication() {
	  Doller five = new Doller(5);
	  five.times(2);
	  assertEquals(10, five.amount);
  }
}