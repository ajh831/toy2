package com.fastcampus.toy2.dao.Product;

import com.fastcampus.toy2.domain.Product.ProductColorDto;

import java.util.List;

public interface ProductColorDao {
	int count() throws Exception;
    ProductColorDto selectByColorCode(String color_code) throws Exception;
    List<ProductColorDto> selectAll() throws Exception;
    int insert(ProductColorDto productColorDto) throws Exception;
    int update(ProductColorDto productColorDto) throws Exception;
    int delete(ProductColorDto productColorDto) throws Exception;
    int deleteAll() throws Exception;
}
