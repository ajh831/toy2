package com.fastcampus.toy2.dao.Product;

import com.fastcampus.toy2.domain.Product.ProductDto;

import java.util.List;

public interface ProductDao {
    int count() throws Exception;
    int salecount() throws Exception;
    ProductDto selectById(String product_id) throws Exception;
    List<ProductDto> selectAll() throws Exception;
    List<ProductDto> selectSale() throws Exception;
    int insert(ProductDto productDto) throws Exception;
    int update(ProductDto productDto) throws Exception;
    int updateSaleState(String product_id) throws Exception;
    int delete(ProductDto productDto) throws Exception;
    int deleteAll() throws Exception;

    List<ProductDto> findProductpage(int page, int size) throws Exception;
}