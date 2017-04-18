package com.globomart.service.api;

import java.util.List;

import com.globomart.dto.Price;
import com.globomart.dto.ProductDto;

public interface IPricingService {

	Price getPrice(List<ProductDto> productVos);
}
