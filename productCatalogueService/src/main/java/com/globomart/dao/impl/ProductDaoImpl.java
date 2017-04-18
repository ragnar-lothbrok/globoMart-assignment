package com.globomart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.globomart.dao.IProductDao;
import com.globomart.dto.ProductDto;

@Service
public class ProductDaoImpl implements IProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProductDto> findByTypeAndName(String type, String name) {
		return jdbcTemplate.query("select * from product where type=? and name =? ", productDtoRowMapper, type, name);
	}

	@Override
	public List<ProductDto> findByType(String type) {
		return jdbcTemplate.query("select * from product where type=?", productDtoRowMapper, type);
	}

	@Override
	public List<ProductDto> findAll() {
		return jdbcTemplate.query("select * from product", productDtoRowMapper);
	}

	@Override
	public void delete(String id) {
		jdbcTemplate.update("delete from product where id= ?", id);

	}

	@Override
	public void save(ProductDto productDto) {
		jdbcTemplate.update("insert into product values (?,?,?)", productDto.getProductId(), productDto.getName(),
				productDto.getType());
	}

	private RowMapper<ProductDto> productDtoRowMapper = new RowMapper<ProductDto>() {
		@Override
		public ProductDto mapRow(ResultSet resultSet, int i) throws SQLException {
			ProductDto productDto = new ProductDto();
			productDto.setProductId(resultSet.getString("id"));
			productDto.setName(resultSet.getString("name"));
			productDto.setType(resultSet.getString("type"));
			return productDto;
		}
	};
}
