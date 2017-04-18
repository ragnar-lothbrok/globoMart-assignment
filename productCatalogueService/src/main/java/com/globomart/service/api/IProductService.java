package com.globomart.service.api;

import com.globomart.dto.ProductDto;

import java.util.List;

public interface IProductService {

	ProductDto addProduct(ProductDto productVo);

	List<ProductDto> getProducts();

	void deleteProduct(String id);

	List<ProductDto> getProductsByTypeAndName(String type, String name);

	List<ProductDto> getProductsByType(String type);
}
