package com.mgdcp.cont.db;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

import mcgdp.cont.db.ConnDB;

public class ConnUserTest {
	@Test
	public void testDB() {
		ConnDB conn = new ConnDB("\\db\\users.db");
		Assert.assertEquals(true, conn.getConnection());
	}
}
