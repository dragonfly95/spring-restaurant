package com.system.restaurant.alexr.dynaenum;


import com.sun.tools.javac.util.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DigitsDynaEnumTest {
//	@Test
//	public void testDirectAccess() {
//		Assert.assertEquals(0, DigitsDynaEnum.ZERO.ordinal());
//	}
//
//	@Test
//	// valueOf() belongs to DynaEnum. I suppressed warning by annotation.
//	// Other solution is to implement trivial valueOf() that just calls parent's implementation in DigitsDynaEnum.
//	@SuppressWarnings("static-access")
//	public void testValueOf() {
//		Assert.assertEquals(1, DigitsDynaEnum.valueOf(DigitsDynaEnum.class, "ONE").ordinal());
//	}
	
	@Test
	public void testValues() {
		DigitsDynaEnum[] values = (DigitsDynaEnum[])DigitsDynaEnum.values();
		assertEquals(4, values.length);
		assertArrayEquals(new DigitsDynaEnum[] {DigitsDynaEnum.ZERO, DigitsDynaEnum.ONE, DigitsDynaEnum.TWO, DigitsDynaEnum.THREE}, values);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testEquals() {
		assertTrue(DigitsDynaEnum.ONE == DigitsDynaEnum.ONE);
		assertTrue(DigitsDynaEnum.ONE != DigitsDynaEnum.TWO);
		
		assertEquals(DigitsDynaEnum.ONE, DigitsDynaEnum.ONE);
		assertEquals(DigitsDynaEnum.ONE, DigitsDynaEnum.valueOf(DigitsDynaEnum.class, "ONE"));
	}
	
}
