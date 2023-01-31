package com.acastillo.dev.test.application.services;

import java.util.List;

import com.acastillo.dev.test.dto.ProductDetailDto;

public interface IProductService {
	List<ProductDetailDto> getProductSimilar(String productId);

}
