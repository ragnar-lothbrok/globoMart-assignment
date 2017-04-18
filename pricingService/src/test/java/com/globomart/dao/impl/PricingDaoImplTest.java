package com.globomart.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.globomart.PricingServiceApp;
import com.globomart.dao.IPricingDao;
import com.globomart.dto.Price;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PricingServiceApp.class)
@WebAppConfiguration
public class PricingDaoImplTest {

	@SuppressWarnings("unused")
	private EmbeddedDatabase db;

	@Autowired
	private IPricingDao pricingDao;

	@Before
	public void setUp() {
//		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-db.sql")
//				.addScript("insert-data.sql").build();
	}

	@Test
	public void testFindByProductId() {
		Price price = pricingDao.findByProductId("SDL930842002");
		Assert.assertNotNull(price);
	}
}
