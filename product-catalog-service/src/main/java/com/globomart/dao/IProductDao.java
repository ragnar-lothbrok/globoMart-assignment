package com.globomart.dao;

import com.globomart.dto.ProductDto;

import java.util.List;

public interface IProductDao {

	List<ProductDto> findByTypeAndName(String type, String name);

	List<ProductDto> findByType(String type);

	List<ProductDto> findAll();

	void delete(String id);

	void save(ProductDto ProductDto);

}
