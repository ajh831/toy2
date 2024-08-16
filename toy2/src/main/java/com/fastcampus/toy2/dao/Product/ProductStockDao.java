package com.fastcampus.toy2.dao.Product;

import com.fastcampus.toy2.domain.Product.ProductStockDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductStockDao {

    List<ProductStockDto> selectByProductId(String product_id) throws Exception;
}
