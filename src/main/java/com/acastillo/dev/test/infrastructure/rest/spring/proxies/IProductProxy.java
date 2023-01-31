package com.acastillo.dev.test.infrastructure.rest.spring.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acastillo.dev.test.dto.existingApis.ProductDetailDto;

import io.swagger.annotations.ApiParam;

@FeignClient(name = "existing-apis", url = "http://localhost:3001")
public interface IProductProxy {

	@RequestMapping(value = "/product/{productId}/similarids", method = RequestMethod.GET)
	ResponseEntity<List<String>> getProductSimilarIds(@ApiParam(value = "", required = true) @PathVariable("productId") String productId);
	
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	ResponseEntity<ProductDetailDto> getProductProductId(@ApiParam(value = "", required = true) @PathVariable("productId") String productId);
}
