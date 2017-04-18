package com.globomart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.globomart.ProductCatalogServiceApp;
import com.globomart.dto.ProductDto;
import com.globomart.service.api.IProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProductCatalogServiceApp.class)
@WebAppConfiguration
public class ProductServiceImplTest {

	@Autowired
	private IProductService productService;

	private List<ProductDto> productDtos;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		productDtos = new ArrayList<>();
		ProductDto productDto = new ProductDto();
		productDto.setProductId("SDL9876762");
		productDto.setName("Arrow");
		productDto.setType("Shirt");
		productDtos.add(productDto);
		productDto = new ProductDto();
		productDto.setProductId("SDL12121213");
		productDto.setName("Perter England");
		productDto.setType("Shirt");
		productDtos.add(productDto);
	}

	@Test
	public void testGetProducts() {
		List<ProductDto> productDtoList = productService.getProducts();
		Assert.assertTrue(productDtoList.size() == productDtos.size());
	}

	@Test
	public void testDeleteProduct() {
		productService.deleteProduct("SDL9876762");
	}

	@Test
	public void testGetProductsByTypeAndName() {
		List<ProductDto> productDtoList = productService.getProductsByTypeAndName("Shirt", "Peter England");
		Assert.assertTrue(productDtoList.size() == productDtos.size());
	}

	@Test
	public void testGetProductsByType() {
		List<ProductDto> productDtoList = productService.getProductsByType("Shirt");
		Assert.assertTrue(productDtoList.size() == productDtos.size());
	}
}
