package com.mgdcp.cont.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class Main {
	@Before
	public void setUp() throws Exception {
		System.out.println(System.getProperties());
	}
	
	@Test
	public void testMain() {
		Assert.assertEquals("Hola", "Hola");
	}

}
