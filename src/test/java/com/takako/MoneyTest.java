package com.takako;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class MoneyTest {
  @Test
  public void testMultiplication() {
	  Doller five = new Doller(5);
	  assertEquals(new Doller(10), five.times(2));
	  assertEquals(new Doller(15), five.times(3));
  }
  
  public void testEquality() {
	  // TestNG��assertTrue(actual, expected)�̏��ɒ���
	  // assertJUnit�Ƃ����̂��C���|�[�g�����
	  assertTrue(new Doller(5).equals(new Doller(5)));
	  assertFalse(new Doller(5).equals(new Doller(6)));
  }
}