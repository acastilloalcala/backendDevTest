package com.acastillo.dev.test.infrastructure.mappers;

import org.mapstruct.Mapper;

import com.acastillo.dev.test.dto.ProductDetailDto;

@Mapper(componentModel = "spring")
public interface ProductDetailDtoMapper {
	
	ProductDetailDto toDto(com.acastillo.dev.test.dto.existingApis.ProductDetailDto existingProduct);
	
	com.acastillo.dev.test.dto.existingApis.ProductDetailDto toExistingProduct(ProductDetailDto dto);

}
