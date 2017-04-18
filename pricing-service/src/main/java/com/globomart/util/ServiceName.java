package com.globomart.util;

public enum ServiceName {

	PRODUCT_CATALOGUE_SERVICE("PRODUCTCATALOGSERVICE");

	private String name;

	ServiceName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
