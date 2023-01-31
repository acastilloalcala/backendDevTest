package com.acastillo.dev.test.infrastructure.rest.spring.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acastillo.dev.test.application.services.IProductService;
import com.acastillo.dev.test.dto.ProductDetailDto;
import com.acastillo.dev.test.spec.ProductApi;


import io.swagger.annotations.ApiParam;

@RestController
public class ProductController implements ProductApi{
	
	@Autowired
	private IProductService productService;
	
	@Override
    public ResponseEntity<List<ProductDetailDto>> getProductSimilar(@ApiParam(value = "",required=true) @PathVariable("productId") String productId){
		List<ProductDetailDto> productsSimilar = productService.getProductSimilar(productId);
		return new ResponseEntity<>(productsSimilar, HttpStatus.OK);
	}

}
