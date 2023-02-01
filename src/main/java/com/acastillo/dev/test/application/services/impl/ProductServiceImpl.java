package com.acastillo.dev.test.application.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acastillo.dev.test.application.exceptions.ResourceNotFoundException;
import com.acastillo.dev.test.application.services.IProductService;
import com.acastillo.dev.test.dto.ProductDetailDto;
import com.acastillo.dev.test.infrastructure.mappers.ProductDetailDtoMapper;
import com.acastillo.dev.test.infrastructure.rest.spring.proxies.IProductProxy;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductProxy productProxy;
	
	@Autowired
	private ProductDetailDtoMapper productMapper = Mappers.getMapper(ProductDetailDtoMapper.class);

	@Override
	public List<ProductDetailDto> getProductSimilar(String productId) {
		List<String> similarIds = new ArrayList<>();
		try {
			similarIds = productProxy.getProductSimilarids(productId).getBody();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Product similar id: " + productId + " not found.");
		}
		List<com.acastillo.dev.test.dto.existingApis.ProductDetailDto> products = new ArrayList();
		similarIds.forEach( id->{
				try {
					products.add(productProxy.getProductProductId(id).getBody());
				} catch(Exception e) {
					throw new ResourceNotFoundException("Product id: " + id + " not found.");
				}
			});
		List<ProductDetailDto> result = products.stream().map(productMapper::toDto).collect(Collectors.toList());
		
		return result;
	}
	

}
