package com.system.restaurant.alexr.dynaenum;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WritersDynaEnumTest {
	@Test
	public void testValuesLength() {
		assertEquals(3, WritersDynaEnum.values().length);
	}
	
	@Test
	public void testValues() {
		WritersDynaEnum[] values = WritersDynaEnum.values();
		
		assertEquals("Pushkin", values[0].name());
		assertEquals("Russian", values[0].nationality());

		assertEquals("Byron", values[1].name());
		assertEquals("British", values[1].nationality());

		assertEquals("Hugo", values[2].name());
		assertEquals("French", values[2].nationality());
	}
	
}
