package com.fastcampus.toy2.dao.Product;

import com.fastcampus.toy2.domain.Product.ProductStockDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductStockDaoImpl implements ProductStockDao {
    @Autowired
    private SqlSession sqlSession;
    private static String namespace = "com.fastcampus.toy2.dao.Product.ProductStockMapper.";

    public List<ProductStockDto> selectByProductId(String product_id) throws Exception {
        return sqlSession.selectList(namespace + "selectByProductId", product_id);
    }
}
