package com.mgdcp.cont.db;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

import mcgdp.cont.db.ConnUser;

public class ConnUserTest {
	@Test
	public void testDB() {
		ConnUser conn = new ConnUser();
		Assert.assertEquals(true, conn.getConnection());
	}
}
