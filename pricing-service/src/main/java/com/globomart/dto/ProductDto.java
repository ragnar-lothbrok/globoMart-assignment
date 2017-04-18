package com.globomart.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String type;

	private String setProductId;

	public String getProductId() {
		return setProductId;
	}

	public void setProductId(String sku) {
		this.setProductId = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", type=" + type + ", ProductId=" + setProductId + "]";
	}

}
