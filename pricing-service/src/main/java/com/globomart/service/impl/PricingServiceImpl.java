package com.globomart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.globomart.constants.PricingConstants;
import com.globomart.dao.IPricingDao;
import com.globomart.dto.Price;
import com.globomart.dto.ProductDto;
import com.globomart.service.api.IPricingService;

@Service
public class PricingServiceImpl implements IPricingService {

	@Autowired
	private IPricingDao pricingDao;

	@Override
	public Price getPrice(final List<ProductDto> productVos) {
		if (CollectionUtils.isEmpty(productVos)) {
			throw new RuntimeException(PricingConstants.NO_PRODUCT_FOUND);
		}
		ProductDto productVo = productVos.get(0);
		final Price price = pricingDao.findByProductId(productVo.getProductId());
		if (price == null || price.getPrice() == null) {
			throw new RuntimeException(PricingConstants.NO_PRODUCT_FOUND);
		}
		return price;
	}
}
