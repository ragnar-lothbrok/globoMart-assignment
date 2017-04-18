package com.globomart.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.globomart.ProductCatalogServiceApp;
import com.globomart.dto.ProductDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProductCatalogServiceApp.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoImplTest {

	@SuppressWarnings("unused")
	private static EmbeddedDatabase db;

	@Autowired
	private ProductDaoImpl productDao;

	@BeforeClass
	public static void setUp() {
//		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-db.sql")
//				.addScript("insert-data.sql").build();
	}

	@Test
	public void test3FindByTypeAndName() {
		List<ProductDto> productDtos = productDao.findByTypeAndName("Shirt", "Levis");
		Assert.assertTrue(productDtos.size() != 4);
	}

	@Test
	public void test2FindByType() {
		List<ProductDto> productDtos = productDao.findByType("Shirt");
		Assert.assertTrue(productDtos.size() != 4);
	}

	@Test
	public void test1FindAll() {
		List<ProductDto> productDtos = productDao.findAll();
		Assert.assertTrue(productDtos.size() == 4);

	}

	@Test
	public void test4Delete() {
		productDao.delete("SDL1234570");
		List<ProductDto> productDtos = productDao.findAll();
		Assert.assertTrue(productDtos.size() == 3);
	}

	@Test
	public void test5Save() {
		ProductDto productDto = new ProductDto();
		productDto.setProductId("SDL1234571");
		productDto.setType("Shirt");
		productDto.setName("Arrow");
		productDao.save(productDto);
		List<ProductDto> productDtos = productDao.findAll();
		Assert.assertTrue(productDtos.size() == 4);
	}
}
