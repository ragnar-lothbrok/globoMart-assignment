package com.globomart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.globomart.dao.IPricingDao;
import com.globomart.dto.Price;

@Service
public class PricingDaoImpl implements IPricingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Price findByProductId(String sku) {
		return jdbcTemplate.queryForObject("select * from price where productId = ?", new RowMapper<Price>() {
			@Override
			public Price mapRow(ResultSet resultSet, int i) throws SQLException {
				Price price = new Price();
				price.setProductId(resultSet.getString("productId"));
				price.setMrp(resultSet.getDouble("mrp"));
				price.setPrice(resultSet.getDouble("price"));
				return price;
			}
		}, sku);
	}
}
