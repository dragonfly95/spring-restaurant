package com.system.restaurant.alexr.dynaenum;


public class DigitsDynaEnum extends DynaEnum<DigitsDynaEnum> {
	public final static DigitsDynaEnum ZERO = new DigitsDynaEnum("ZERO", 0);
	public final static DigitsDynaEnum ONE = new DigitsDynaEnum("ONE", 1);
	public final static DigitsDynaEnum TWO = new DigitsDynaEnum("TWO", 2);
	public final static DigitsDynaEnum THREE = new DigitsDynaEnum("THREE", 3);
	
	
	protected DigitsDynaEnum(String name, int ordinal) {
		super(name, ordinal);
	}

    public static <E> DynaEnum<? extends DynaEnum<?>>[] values() {
    	return values(DigitsDynaEnum.class);
    }
	
}
