package com.acastillo.dev.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acastillo.dev.test.application.exceptions.ResourceNotFoundException;
import com.acastillo.dev.test.dto.ProductDetailDto;
import com.acastillo.dev.test.infrastructure.rest.spring.resource.ProductController;

@SpringBootTest
class BackendDevTestApplicationTests {

	@Autowired
	private ProductController productController;

	@Test
	void productSimilar() {
		List<ProductDetailDto> products = productController.getProductSimilar("1").getBody();
		assert products.size() > 0; 
	}
	
	@Test
	void productSimilarResourceNotFoundSimilar() {
		Exception exception = assertThrows(ResourceNotFoundException.class, 
				()-> productController.getProductSimilar("6"));
		
		String exceptionMessage = "Product similar id: 6 not found.";
		assertTrue(exception.getMessage().equals(exceptionMessage));
	}
	
	@Test
	void productSimilarResourceNotFoundProductId() {
		Exception exception = assertThrows(ResourceNotFoundException.class, 
				()-> productController.getProductSimilar("5"));
		
		String exceptionMessage = "Product id: 6 not found.";
		assertTrue(exception.getMessage().equals(exceptionMessage));
	}

}
