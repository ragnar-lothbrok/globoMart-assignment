package com.globomart.controller;

import com.globomart.dto.ProductDto;
import com.globomart.service.api.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductCatalogController {

	@Autowired
	private IProductService productService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductDto addProduct(@RequestBody final ProductDto productVo) {
		return productService.addProduct(productVo);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDto> getProductsByTypeAndName(@RequestParam(value = "type", required = false) final String type,
			@RequestParam(value = "name", required = false) final String name) {
		return productService.getProductsByTypeAndName(type, name);
	}

	@RequestMapping(value = "/searchByType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDto> getProductsByTypeAndName(
			@RequestParam(value = "type", required = false) final String type) {
		return productService.getProductsByType(type);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDto> getProducts() {
		return productService.getProducts();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteProduct(@PathVariable final String id) {
		productService.deleteProduct(id);
	}
}
