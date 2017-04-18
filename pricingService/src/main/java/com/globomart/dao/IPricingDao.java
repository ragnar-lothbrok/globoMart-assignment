package com.globomart.dao;

import com.globomart.dto.Price;

public interface IPricingDao {

	Price findByProductId(String sku);

}
