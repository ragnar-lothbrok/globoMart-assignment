package com.globomart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.globomart.PricingServiceApp;
import com.globomart.dto.Price;
import com.globomart.dto.ProductDto;
import com.globomart.service.api.IPricingService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PricingServiceApp.class)
@WebAppConfiguration
public class PricingServiceImplTest {

	@Autowired
	private IPricingService pricingService;

	private List<ProductDto> productDtos;

	private Price price;

	@Before
	public void setUp() {
		productDtos = new ArrayList<>();
		ProductDto productDto = new ProductDto();
		productDto.setProductId("SDL225151037");
		productDto.setName("BMW");
		productDto.setType("car");
		productDtos.add(productDto);
		price = new Price();
		price.setProductId("SDL225151037");
		price.setMrp(15000d);
		price.setPrice(12599d);
	}

	@Test
	public void testGetPrice() {
		Price output = pricingService.getPrice(productDtos);
		Assert.assertTrue(output.getPrice().toString().equalsIgnoreCase(price.getPrice().toString()));
	}

	@Test(expected = RuntimeException.class)
	public void testGetPriceForNoProductFound() {
		pricingService.getPrice(null);
	}

}
