package com.globomart.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.dao.IProductDao;
import com.globomart.dto.ProductDto;
import com.globomart.service.api.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private IProductDao productDao;

	@Override
	public ProductDto addProduct(ProductDto productVo) {
		try {
			final ProductDto ProductDto = new ProductDto();
			ProductDto.setName(productVo.getName());
			ProductDto.setType(productVo.getType());
			ProductDto.setProductId(productVo.getProductId());
			productDao.save(ProductDto);
			return ProductDto;
		} catch (Exception e) {
			LOGGER.error("Exception occured while saving product {} ", e);
			throw new RuntimeException("Not able to save product.");
		}
	}

	@Override
	public List<ProductDto> getProducts() {
		return productDao.findAll();
	}

	@Override
	public void deleteProduct(String id) {
		try {
			productDao.delete(id);
		} catch (Exception e) {
			LOGGER.error("Exception occured while deleting product {} ", e);
			throw new RuntimeException("Not able to delete product.");
		}
	}

	@Override
	public List<ProductDto> getProductsByTypeAndName(String type, String name) {
		return productDao.findByTypeAndName(type, name);
	}

	@Override
	public List<ProductDto> getProductsByType(String type) {
		return productDao.findByType(type);
	}
}
