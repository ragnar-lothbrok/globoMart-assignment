package com.globomart.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.globomart.dto.Price;
import com.globomart.dto.ProductDto;
import com.globomart.service.api.IPricingService;
import com.globomart.util.ServiceName;

@RestController
@RequestMapping("products/price")
public class PricingController {

	@Autowired
	private IPricingService pricingService;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public Price getPrice(@RequestParam(value = "name", required = true) final String name,
			@RequestParam(value = "type", required = true) final String type) {
		String url = "http://" + ServiceName.PRODUCT_CATALOGUE_SERVICE.getName() + "/products/search?name=" + name + "&type=" + type;
		ProductDto[] productDtos = restTemplate.getForObject(url, ProductDto[].class);
		return pricingService.getPrice(Arrays.asList(productDtos));
	}

}
